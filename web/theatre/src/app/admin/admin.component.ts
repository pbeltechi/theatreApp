import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Admin, httpOptions, Representation} from "../model/representation";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  isLoggedIn: boolean = false;
  loginError: string;
  baseUrl: string = 'http://localhost:8080/api/';
  password: string;
  username: string;
  representations: Representation[];
  selectedRepresentation: Representation;
  selectedRepresentationLi: HTMLLIElement;
  reprTitle: string;
  reprDate: string;
  reprTime: string;
  reprLocation: string;
  reprError: string;

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  login(): void {
    const url = this.baseUrl + 'admin/';
    const admin = new Admin(0,this.username,this.password);
    this.httpClient.post(url, admin, httpOptions).subscribe(
      () => {
        this.isLoggedIn = true;
        this.getAllRepresentations();
      },
      (_) => {this.loginError = 'incorrect username or password'}
    );
  }

  getAllRepresentations(): void {
    const url = this.baseUrl+'representation/';
    this.httpClient.get(url, httpOptions).subscribe((result: Representation[]) => {
      this.representations = result;
    });
  }

  representationClick(li: HTMLLIElement, representation: Representation): void {
    if(this.selectedRepresentation && li !== this.selectedRepresentationLi){
      this.selectedRepresentation = null;
      this.selectedRepresentationLi.classList.remove('clicked');
    }
    if(li.classList.contains('clicked')) {
      li.classList.remove('clicked');
      this.selectedRepresentation = null;
      this.selectedRepresentationLi = null;
    } else {
      li.classList.add('clicked');
      this.selectedRepresentation = representation;
      this.selectedRepresentationLi = li;
      this.initializeInputs();
    }
  }

  private initializeInputs(): void {
    this.reprTitle = this.selectedRepresentation.title;
    this.reprTime = '' + this.selectedRepresentation.time;
    this.reprDate = this.selectedRepresentation.date.toString();
    this.reprLocation = this.selectedRepresentation.location;
  }

  getReprFromInputs(): Representation {
    const date: Date = new Date(this.reprDate + ' '+ this.reprTime);
    const timeString = this.reprTime.split(':');
    const time = [+timeString[0] ,+timeString[1]];
    return new Representation(0,this.reprTitle,this.reprLocation,date,time);
  }

  add(): void {
    const url = this.baseUrl+'representation/';
    const representation = this.getReprFromInputs();
    console.log(representation);
    this.httpClient.post<Representation>(url,representation, httpOptions).subscribe((response) => {
      this.getAllRepresentations();
      this.setDefaults();
    },
      (err) => {
      this.reprError = err.message;
        setTimeout(() => {
          this.reprError = undefined;
        }, 3000);
    });
  }

  update(): void {
    const url = this.baseUrl+'representation/';
    const representation = this.getReprFromInputs();
    representation.id = this.selectedRepresentation.id;
    this.httpClient.put<Representation>(url,representation, httpOptions).subscribe((response) => {
        this.getAllRepresentations();
        this.setDefaults();
      },
      (err) => {
        this.reprError = err.message;
        setTimeout(() => {
          this.reprError = undefined;
        }, 3000);
      });
  }

  delete(): void {
    const url = this.baseUrl+'representation?id=' + this.selectedRepresentation.id;
    this.httpClient.delete<number>(url, httpOptions).subscribe((response) => {
        this.getAllRepresentations();
        this.setDefaults();
      },
      (err) => {
        this.reprError = err.message;
        setTimeout(() => {
          this.reprError = undefined;
        }, 3000);
      });
  }

  private setDefaults(): void {
    this.selectedRepresentation = null;
    this.selectedRepresentationLi.classList.remove('clicked');
  }
}

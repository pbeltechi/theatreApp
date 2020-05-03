import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {httpOptions, Representation} from "../model/representation";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  representations: Representation[];

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(): void {
    this.loadRepresentations();
  }

  loadRepresentations(): void {
    const url = 'http://localhost:8080/api/representation/'
    this.httpClient.get(url, httpOptions).subscribe((result: Representation[]) => {
      this.representations = result;
    });
  }
}

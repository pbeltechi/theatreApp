import {HttpHeaders} from "@angular/common/http";
import {Time} from "@angular/common";

export class Admin {
  id: number;
  username: string;
  password: string;
  constructor(id,username,password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }
}

export class Seat {
  id: number;
  row: number;
  lodge: string;
  seatNumber: number;
  price: number;

  constructor(id: number, row: number, lodge: string, seatNumber: number, price: number) {
    this.id = id;
    this.row = row;
    this.lodge = lodge;
    this.seatNumber = seatNumber;
    this.price = price;
  }
}

export class SeatDTO extends Seat {
  reserved: boolean;
  selected: boolean = false;
}

export class Client {
  id: number;
  firstName: string;
  lastName: string;

  constructor(firstName: string, lastName: string) {
    this.id = 0;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}

export class Reservation {
  id: number;
  representation: Representation;
  client: Client;
  seats: Seat[];

  constructor(representation: Representation, client: Client, seats: Seat[]) {
    this.id = 0;
    this.representation = representation;
    this.client = client;
    this.seats = seats;
  }
}

export class Representation {
  id: number;
  title: string;
  date: Date;
  time: Time;
  location: string;
  seats: Seat[];

  constructor(id,title,location,date,time) {
    this.id = id;
    this.title = title;
    this.location = location;
    this.date = date;
    this.time = time;
    this.seats = [];
  }
}

export const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

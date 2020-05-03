import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Client, httpOptions, Representation, Reservation, Seat, SeatDTO} from "../model/representation";

@Component({
  selector: 'app-reserve',
  templateUrl: './reserve.component.html',
  styleUrls: ['./reserve.component.css']
})
export class ReserveComponent implements OnInit {
  tonightRepresentation: Representation;
  roomSeats: SeatDTO[];
  firstName: string;
  lastName: string;
  error: string;
  information: string;
  price: number = 0;

  constructor(private httpClient: HttpClient) {
  }

  public static getSeatFromSeatDTO(seatDTO: SeatDTO): Seat {
    return new Seat(seatDTO.id, seatDTO.row, seatDTO.lodge, seatDTO.seatNumber, seatDTO.price);
  }

  ngOnInit(): void {
    this.getTonightRepresentation();
  }

  getTonightRepresentation(): void {
    const date = new Date('2020-06-20');
    const url = 'http://localhost:8080/api/representation/date?date=' + date.toISOString().split('T')[0];
    this.httpClient.get(url, httpOptions).subscribe((result: Representation[]) => {
      this.tonightRepresentation = result[0];
      this.setRoomConfiguration();
    });
  }

  private setRoomConfiguration() {
    const url = 'http://localhost:8080/api/representation/room?id=' + this.tonightRepresentation.id;
    this.httpClient.get(url, httpOptions).subscribe((result: SeatDTO[]) => {
      this.roomSeats = result;
    });
  }

  selectSeat(seatDiv: HTMLDivElement, seat: SeatDTO): void {
    if (seat.reserved) {
      this.error = 'This seat is already reserved!';
      setTimeout(() => {
        this.error = undefined;
      }, 3000);
      return;
    }
    if (seat.selected) {
      this.price -= seat.price;
      seatDiv.classList.remove('selected-seat');
    } else {
      this.price += seat.price;
      seatDiv.classList.add('selected-seat');
    }
    seat.selected = !seat.selected;
  }

  canReserve(): boolean {
    let selected = false;
    if (!this.roomSeats) {
      return false;
    }
    this.roomSeats.forEach((seat: SeatDTO) => {
      if (seat.selected) {
        selected = true;
      }
    });
    return !(this.firstName && this.lastName && selected);
  }

  reserveSeats(): void {
    let selectedSeats: Seat[] = [];
    this.roomSeats.forEach((seat: SeatDTO) => {
      if (seat.selected) {
        selectedSeats.push(ReserveComponent.getSeatFromSeatDTO(seat));
      }
    });
    const client = new Client(this.firstName, this.lastName);
    const reservation = new Reservation(this.tonightRepresentation, client, selectedSeats);
    this.saveReservation(reservation);
  }

  saveReservation(reservation: Reservation): void {
    const url = 'http://localhost:8080/api/reservation/save'
    this.httpClient.post(url, reservation, httpOptions).subscribe(() => {
      this.information = 'Reservation was completed successfully';
      setTimeout(() => {
        this.information = undefined;
      }, 3000);
    });
  }
}

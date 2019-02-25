import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-reservations',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  model: ReservationViewModel = {
    reserveDate: "",
    checkin: "",
    checkout: "",
    roomid: 0,
    guestid: 0
  };

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  sendReservationForm(): void {
    // alert(this.model.first_name)
    // The url of our backend guest api
    let url = "http://localhost:8080/api/v1/reservation";
    // Submit a post request to this url and send the model
    // (that basically models what data the api accepts)
    this.http.post(url, this.model).subscribe(
      res => {
        location.reload();
      },
      err => {
        alert("An error has occurred while sending reservation");
      }
    );
  }

}

export interface ReservationViewModel {
  reserveDate: string;
  checkin: string;
  checkout: string;
  roomid: number;
  guestid: number;
}

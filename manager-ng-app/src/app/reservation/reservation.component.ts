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



}

export interface ReservationViewModel {
  reserveDate: string;
  checkin: string;
  checkout: string;
  roomid: number;
  guestid: number;
}

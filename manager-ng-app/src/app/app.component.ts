import { Component, OnInit} from '@angular/core';
import { HttpClient } from "@angular/common/http"
import { Guest } from "./model/guest"

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent implements OnInit{
  title = 'manager-ng-app';
  guests: Guest[] = [];
  // array = [
  //   {
  //     first_name:"ANU",
  //     last_name: "Srikanth",
  //     address1: "grweqav",
  //     address2: "wregav",
  //     city: "New Yrok Ciryt",
  //     state: "NY",
  //     zip: "23432",
  //     phone: "3273249321",
  //     email: "agirbj@gmail.com"
  //   },
  //   {
  //     guid: '880381d3-8dca-4aed-b207-b3b4e575a15f',
  //     age: 25,
  //     name: 'Adrian Lawrence'
  //   },
  //   {
  //     guid: '87b47684-c465-4c51-8c88-3f1a1aa2671b',
  //     age: 32,
  //     name: 'Boyer Stanley'
  //   }
  // ];

  constructor(private http: HttpClient) {

  }

  ngOnInit() {
    this.getAllGuests();
  }

  public getAllGuests(){
    let url = "http://localhost:8080/api/v1/guest";
    this.http.get<Guest[]>(url).subscribe(
      res => {
        this.guests = res
      },
      error => {
        alert("An error has occurred while retrieving guests");
      }
    )
  }
}

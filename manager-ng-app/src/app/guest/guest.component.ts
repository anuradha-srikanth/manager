import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http"
// declare var require: any

@Component({
  selector: 'app-guest',
  templateUrl: './guest.component.html',
  styleUrls: ['./guest.component.css']
})
export class GuestComponent implements OnInit {
  model: GuestViewModel = {
    first_name: '',
    last_name: '',
    address1: '',
    address2: '',
    city: '',
    state: '',
    zip: '',
    phone: '',
    email: ''
  };

  constructor(private http: HttpClient) {

  }

  ngOnInit() {
  }

  sendGuestForm(): void{
    // alert(this.model.first_name)
    // The url of our backend guest api
    let url = "http://localhost:8080/api/v1/guest";
    // Submit a post request to this url and send the model
    // (that basically models what data the api accepts)
    this.http.post(url, this.model).subscribe(
      res => {
        location.reload();
      },
      err => {
        alert("An error has occurred while sending guest");
      }
    );
  }
}


export interface GuestViewModel{
  first_name:string;
  last_name: string;
  address1: string;
  address2: string;
  city: string;
  state: string;
  zip: string;
  phone: string;
  email: string;
}

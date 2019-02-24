import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-guest',
  templateUrl: './guest.component.html',
  styleUrls: ['./guest.component.css']
})
export class GuestComponent implements OnInit {
  model: GuestViewModel = {
    firstname: '',
    last_name: '';
    address: '';
    city: '';
    state: '';
    zip: '';
    phone: '';
  };

  constructor() { }

  ngOnInit() {
  }

}


export interface GuestViewModel{
  first_name:string;
  last_name: string;
  address: string;
  city: string;
  state: string;
  zip: string;
  phone: string;
}

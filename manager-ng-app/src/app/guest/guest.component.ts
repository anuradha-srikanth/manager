import { Component, OnInit } from '@angular/core';

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

  constructor() { }

  ngOnInit() {
  }

  sendGuestForm(): void{
    alert(this.model.first_name)
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

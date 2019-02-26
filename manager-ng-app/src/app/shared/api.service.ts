import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Guest} from '../model/guest';
import {GuestViewModel} from '../guest/guest.component'
import {Observable} from 'rxjs';

// Now we are able to inject this into other components based on angular's injecting
@Injectable({
  providedIn: 'root'
})
export class ApiService {
  // The url of our backend guest api
  private BASE_URL = "http://localhost:8080/api/v1";
  private GET_GUESTS_URL = `${this.BASE_URL}/guest`;
  private POST_GUEST_URL = `${this.BASE_URL}/guest`;

  constructor(private http: HttpClient) { }

  getAllGuests() : Observable<Guest[]> {
    return this.http.get<Guest[]>(this.GET_GUESTS_URL);
  }

// In this function we are just going to return an observable without subscribing
// to it because subscribing would trigger the request and return the data whereas
// we want the entity calling it to trigger the api call
  postNewGuest(guest: GuestViewModel) : Observable<any> {
    // Submit a post request to this url and send the model
    // (that basically models what data the api accepts)
    return this.http.post(this.POST_GUEST_URL, guest);
  }
}

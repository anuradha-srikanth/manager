import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GuestComponent } from './guest/guest.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ReservationComponent } from './reservation/reservation.component';

const routes: Routes = [
{
  path: 'guests',
  component: GuestComponent,
},
{
  path: 'reservations',
  component: ReservationComponent,
},
{
  path:'',
  component: GuestComponent,
  pathMatch:'full'
},
{
  path: '**',
  component: NotFoundComponent,
}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {enableTracing: true})
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

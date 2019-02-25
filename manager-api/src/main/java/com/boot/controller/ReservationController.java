package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Reservation;
import com.boot.service.ReservationServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value="/api/v1")
public class ReservationController {
	
	@Autowired
	private ReservationServiceImpl reservationService;

	@RequestMapping(value = "/reservation", method= RequestMethod.GET)
	public List<Reservation> index(){
		return reservationService.index();
	}
	
	@RequestMapping(value = "/reservation/{id}", method= RequestMethod.GET)
	public Reservation get(@PathVariable Long id){
		return reservationService.get(id);
	}
	
	@RequestMapping(value="/reservation", method=RequestMethod.POST)
	public Reservation create(@RequestBody Reservation reservation) {
		return reservationService.create(reservation);
	}
	
	@RequestMapping(value="/reservation/{id}", method=RequestMethod.DELETE)
	public Reservation delete(@PathVariable Long id) {
		return reservationService.deleteById(id);
	}
	
	@RequestMapping(value="/reservation/{id}", method=RequestMethod.PUT)
	public Reservation update(@PathVariable Long id, @RequestBody Reservation updatedReservation) {
		return reservationService.update(id, updatedReservation);
	}
	
}

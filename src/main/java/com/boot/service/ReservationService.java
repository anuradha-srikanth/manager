package com.boot.service;

import java.util.List;

import com.boot.model.Reservation;

public interface ReservationService {

	List<Reservation> index();

	Reservation get(Long id);
	
	Reservation create(Reservation reservation);

	Reservation deleteById(Long id);
	
	Reservation update(Long id, Reservation updatedReservation);
}

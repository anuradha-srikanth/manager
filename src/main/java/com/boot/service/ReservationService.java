package com.boot.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.Reservation;
import com.boot.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;

	public List<Reservation> index() {
		return reservationRepository.findAll();
	}

	public Reservation get(Long id) {
		try {
			Reservation reservation = reservationRepository.getOne(id);
			return reservation;
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Reservation create(Reservation reservation) {
		return reservationRepository.saveAndFlush(reservation);
	}

	public Reservation deleteById(Long id) {
		Reservation reservation = reservationRepository.getOne(id);
		if (reservation != null) {
			reservationRepository.deleteById(id);
		}
		Reservation removed = reservationRepository.getOne(id);
        if (removed != null) {
            return null;
        }
		return reservation;
	}
	
	public Reservation update(Long id, Reservation updatedReservation) {
		Reservation reservation = reservationRepository.getOne(id);
		BeanUtils.copyProperties(updatedReservation, reservation);
		return reservationRepository.saveAndFlush(reservation);
	}

}

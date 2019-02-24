package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}

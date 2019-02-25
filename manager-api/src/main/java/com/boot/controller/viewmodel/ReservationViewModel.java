package com.boot.controller.viewmodel;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class ReservationViewModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotEmpty
	private Date reserveDate;
	
	@NotEmpty
	private Date checkInDate;
	
	@NotEmpty
	private Date checkOutDate;
	
	@NotEmpty
	private Long room_id;
	
	@NotEmpty
	private Long guest_id;
	
}

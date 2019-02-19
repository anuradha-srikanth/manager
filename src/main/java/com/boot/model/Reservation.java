package com.boot.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	

}

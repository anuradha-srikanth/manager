package com.boot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Date reserveDate;
	private Date checkInDate;
	private Date checkOutDate;
	private Long room_id;
	private Long guest_id;
	
	
	public Reservation() { } 
	
	public Reservation(Long id, Date checkInDate, Date checkOutDate, Long guest_id) {
		super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.guest_id = guest_id;
	}
	
	public Reservation(Long id, Date reserveDate, Date checkInDate, Date checkOutDate, Long room_id, Long guest_id) {
		super();
		this.id = id;
		this.reserveDate = reserveDate;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room_id = room_id;
		this.guest_id = guest_id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Long getRoomId() {
		return room_id;
	}
	public void setRoomId(Long room_id) {
		this.room_id = room_id;
	}
	public Long getGuestId() {
		return guest_id;
	}
	public void setGuestId(Long guest_id) {
		this.guest_id = guest_id;
	}
	

}

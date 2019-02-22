package com.boot.service;

import java.util.List;

import com.boot.model.Guest;

public interface GuestService {
	List<Guest> index();

	Guest get(Long id);
	
	Guest create(Guest guest);

	Guest delete(Long id);
	
	Guest update(Long id, Guest updatedGuest);
}

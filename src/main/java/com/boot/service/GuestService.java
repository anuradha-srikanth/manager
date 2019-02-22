package com.boot.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.Guest;
import com.boot.repository.GuestRepository;

@Service
public class GuestService {

	@Autowired
	private GuestRepository guestRepository;

	public List<Guest> index() {
		return guestRepository.findAll();
	}

	public Guest get(Long id) {
		try {
			Guest guest = guestRepository.getOne(id);
			return guest;
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Guest create(Guest guest) {
		return guestRepository.saveAndFlush(guest);
	}

	public Guest deleteById(Long id) {
		Guest guest = guestRepository.getOne(id);
		if (guest != null) {
			guestRepository.deleteById(id);
		}
		Guest removed = guestRepository.getOne(id);
        if (removed != null) {
            return null;
        }
		return guest;
	}
	
	public Guest update(Long id, Guest updatedGuest) {
		Guest guest = guestRepository.getOne(id);
		BeanUtils.copyProperties(updatedGuest, guest);
		return guestRepository.saveAndFlush(guest);
	}
	
}

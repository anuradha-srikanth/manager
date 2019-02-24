package com.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Guest;
import com.boot.service.GuestService;

@RestController
@CrossOrigin
@RequestMapping(value="api/v1/guest")
public class GuestController {
	
	@Autowired
//	private GuestRepository guestRepository;
	private GuestService guestService;
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public List<Guest> index(){
		return guestService.index();
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public Guest get(@PathVariable Long id){
		return guestService.get(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Guest create(@Valid @RequestBody Guest guest, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		return guestService.create(guest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Guest delete(@PathVariable Long id) {
		return guestService.delete(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Guest update(@PathVariable Long id, @RequestBody Guest updatedGuest) {
		return guestService.update(id, updatedGuest);
	}
	
	
}

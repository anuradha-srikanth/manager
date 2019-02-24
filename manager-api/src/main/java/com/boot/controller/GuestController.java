package com.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Guest;
import com.boot.service.GuestService;

@RestController
@CrossOrigin
@RequestMapping(value="/api/v1")
public class GuestController {
	
	@Autowired
//	private GuestRepository guestRepository;
	private GuestService guestService;
	
	@RequestMapping(value = "/guest", method= RequestMethod.GET)
	public List<Guest> index(){
		return guestService.index();
	}
	
	@RequestMapping(value = "/guest/{id}", method= RequestMethod.GET)
	public Guest get(@PathVariable Long id){
		return guestService.get(id);
	}
	
	@RequestMapping(value="/guest", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Guest create(@RequestBody Guest guest, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		return guestService.create(guest);
	}
	
	@RequestMapping(value="/guest/{id}", method=RequestMethod.DELETE)
	public Guest delete(@PathVariable Long id) {
		return guestService.delete(id);
	}
	
	@RequestMapping(value="/guest/{id}", method=RequestMethod.PUT)
	public Guest update(@PathVariable Long id, @RequestBody Guest updatedGuest) {
		return guestService.update(id, updatedGuest);
	}
	
	
}

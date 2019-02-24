package com.boot.controller.viewmodels;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class GuestViewModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotEmpty
	@Size(min=3, max=15, message="First Name cannot be empty")
	private String first_name;
	
	@Size(min=3, max=15,  message="First Name cannot be empty")
	private String last_name;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state;
	
	@NotEmpty
	@Size(min=1, max=5)
	private String zipcode;
	
	@NotEmpty
	private String phone;
	
	@NotEmpty
	private String email;
	
	
}

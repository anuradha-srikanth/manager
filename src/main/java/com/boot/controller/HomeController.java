package com.boot.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("items")
public class HomeController {
	
	@RequestMapping({"/", "home"})
	public ArrayList<String> getHomePage() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("ABC");
		a.add("EFG");
		a.add("EFG");
		return a;
	}

}

package com.boot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
//@RequestMapping("items")
public class HomeController {
	
//    @Value("${home.message}")
//    private String message;
  
	
	@RequestMapping({"/", "home"})
	public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
//	public String welcome(Map<String, Object> model) {
//        model.put("message", this.message);
//        return "home";
//    }

}

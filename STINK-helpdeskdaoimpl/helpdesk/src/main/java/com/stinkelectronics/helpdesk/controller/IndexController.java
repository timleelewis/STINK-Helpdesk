package com.stinkelectronics.helpdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
	
	//get
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	//post
	@PostMapping("/Index")
	public String indexPost() {
		return "Login";
	}
}

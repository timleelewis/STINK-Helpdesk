package com.stinkelectronics.helpdesk.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stinkelectronics.helpdesk.model.Profile;
import com.stinkelectronics.helpdesk.service.ProfileDao;


@Controller
public class RegisterController {

	@Autowired
	private ProfileDao profdao;

	//get register
	@GetMapping("/Register")
	public String accCheck(Model model) {
		/*
		user.add(new Account());
		user.add(new Profile());
		model.addAttribute("user", user);*/
		model.addAttribute("profile", new Profile());

		return "Register";
	}
	
	@PostMapping("/Register")
	public String registerAccount(@ModelAttribute("profile") Profile profile) {
		
		//nullcheck
		if (profile.getFirstName() == null || profile.getLastName() == null || profile.getUserID() == null) {
			//broadcast that required fields are left empty
			return "Register";
		}
		
		//lengthcheck

		if (!profdao.isUserIdExists(profile.getUserID())) {
			if(profdao.postProfile(profile)) {
				return "Login";
			}
		}
		return "Register";
	}
}


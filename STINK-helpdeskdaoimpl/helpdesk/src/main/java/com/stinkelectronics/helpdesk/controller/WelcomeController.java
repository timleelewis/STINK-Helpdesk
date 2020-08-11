package com.stinkelectronics.helpdesk.controller;

import com.stinkelectronics.helpdesk.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import com.stinkelectronics.helpdesk.service.ProfileDao;
import com.stinkelectronics.helpdesk.service.RepairDao;
import com.stinkelectronics.helpdesk.service.RoleDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionProfile")
public class WelcomeController {

	@Autowired
	private ProfileDao profdao;

	@Autowired
	private RepairDao repairdao;

	@Autowired
	private RoleDao roledao;

	//get welcome
	@ModelAttribute ("sessionProfile")
	public Profile makeSessionProfile() {return new Profile();}


	@GetMapping("/welcome")
	public String findingName(Model model, @ModelAttribute("sessionProfile") Profile sessionProfile) {
		return "welcome";

	}
	//post welcome
	@PostMapping("/welcome")
	public String welcomePost(@ModelAttribute("sessionProfile") Profile sessionProfile) {
		return "welcome";
	}

}

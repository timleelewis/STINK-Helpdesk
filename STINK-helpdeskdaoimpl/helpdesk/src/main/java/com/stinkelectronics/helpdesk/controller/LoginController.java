package com.stinkelectronics.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.stinkelectronics.helpdesk.model.Profile;
import com.stinkelectronics.helpdesk.service.ProfileDao;

@Controller
@SessionAttributes("sessionProfile")
public class LoginController {
	
	@Autowired
	private ProfileDao profdao;
	
	@ModelAttribute("sessionProfile")
	public Profile makeSessionProfile() {return new Profile();}
	
	//get login
	@GetMapping("/Login")
	public String loginForm(Model m, @ModelAttribute("sessionProfile") Profile sessionProfile) {
		m.addAttribute("profile", new Profile());
		return "Login";
	}
	
	//post login
	@PostMapping("/Login")
	public String loginPost(@ModelAttribute("profile") Profile profile, @ModelAttribute("sessionProfile") Profile sessionProfile) {
		//debug purposes
		System.out.println("UserID Entered: " + profile.getUserID());
		System.out.println("Password Entered: " + profile.getPassword());
		
		//null check
		if(profile.getPassword() == null || profile.getUserID() == null) {
			//broadcast that required fields are left empty
			return "Login";
		}
		
		//length check
		//password max 12 char
		//userid max 35 char
		if(profile.getPassword().length() > 12 || profile.getUserID().length() > 35) {
			//broadcast that respective field is too long
			return "Login";
		}
		
		if(profdao.isUserIdExists(profile.getUserID())) {
			//check if password matches account
			if(profile.getPassword().contentEquals(profdao.getProfileByUserID(profile.getUserID()).getPassword())) {
				//login session user
				sessionProfile = profdao.getProfileByUserID(profile.getUserID());
				System.out.println("Login Successful!");
				return "welcome";
			}
			else {
				//broadcast that password does not match userid
				System.out.println("Login Failed: Wrong password");
				return "Login";
			}
		}
		else {
			//broadcast that no such user with userID exists
			System.out.println("Login Failed: User doesn't exist");
			return "Login";
		}
	}
	
	@RequestMapping("/Register")
	public String register() {
		return "Register";
	}
}

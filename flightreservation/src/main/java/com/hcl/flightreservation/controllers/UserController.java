package com.hcl.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.flightreservation.entities.User;
import com.hcl.flightreservation.repos.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userrepository;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}

	@RequestMapping("/showLogin")
	public String LoginPage() {
		return "login/login";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userrepository.save(user);
		return "login/login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelmap) {
		User user = userrepository.findByemail(email);
		if (user.getPassword().equals(password)) {
			return "findFlights";
		} else {
			modelmap.addAttribute("msg", "Invalid Username or password.Please try again");
		}

		return "login/login";
	}
}

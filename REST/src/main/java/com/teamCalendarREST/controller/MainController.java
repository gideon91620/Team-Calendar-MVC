package com.teamCalendarREST.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamCalendarREST.model.Login;

@Controller 
public class MainController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add() {
		return "add";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	
	

}

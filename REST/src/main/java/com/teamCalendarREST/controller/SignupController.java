package com.teamCalendarREST.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.teamCalendarREST.model.Login;
import com.teamCalendarREST.model.User;
import com.teamCalendarREST.service.SignupService;
  
@RestController
public class SignupController {
  
    @Autowired
    SignupService userService; 
    private static Logger logger = LoggerFactory.getLogger(SignupController.class);
    
    @InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@RequestMapping(value = "/users/signup", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody @Valid User form) {
		logger.info("register success {}", form);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(@Valid @ModelAttribute("login") Login form, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			bindingResult
			.getFieldErrors()
			.stream()
			.forEach(f -> mv.addObject("errors", f.getField() + ": " + f.getDefaultMessage()));
			 mv.setViewName("login");
			return mv;
		}else {
			Login newUser = new Login(form.getUsername(), form.getPassword());
			
			logger.info("Log in success {}", form);
			mv.setViewName("login");
			mv.addObject("user", newUser.getUsername());
			
			return mv;			
		}
		
	}
    
 
  
     
	// -------------------- Retrieve All Users ---------------------------------
		@RequestMapping(value = "/users", method = RequestMethod.GET)
		public ResponseEntity<List<User>> getAllUsers() {
			List<User> users = new ArrayList<>();
			
			User user = new User(1L, "Gideon Giorgis", "123test", "123@test");
			User user2 = new User(2L, "testname", "123test", "123@test");
			users.add(user);
			users.add(user2);
			
			
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		
		// ------------------------- Retrieve A User By Id-----------------------------
		@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
		public ResponseEntity<User> getUserById(@RequestParam("id") Long id) {
			User user = userService.findById(id);
			
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
  
     
    
}
  
package com.real.estate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.real.estate.jparepo.UserRepo;
import com.real.estate.model.User;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserRepo userRepository;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		userRepository.save(user);
		return "Registration Successfull";
	}

}

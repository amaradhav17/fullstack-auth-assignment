package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRequest;
import com.example.dto.Registration;
import com.example.service.LoginService;
import com.example.service.RegistrationService;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
		
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody Registration  registration) {
		
		return registrationService.register(registration);
		
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody LoginRequest request) {
		return loginService.login(request);
	}
	

}

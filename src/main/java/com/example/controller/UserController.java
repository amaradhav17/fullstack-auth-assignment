package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/api/user")
	public String userAccess() {
		return "Hello User";
	}
	
	@GetMapping("/api/user/dashboard")
	public String userDashboard() {
	    return "User Dashboard";
	}

}

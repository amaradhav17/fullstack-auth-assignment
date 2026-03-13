package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@GetMapping("/api/admin")
	public String adminController() {
		return "Hello Admin";
	}
	
	@GetMapping("/api/admin/dashboard")
	public String adminDashboard() {
	    return "Admin Dashboard";
	}

}

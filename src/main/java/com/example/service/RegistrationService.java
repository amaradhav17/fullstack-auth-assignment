package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Registration;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepository;
	
	public String register(Registration registration) {
		User user1 = new User();
		

        user1.setName(registration.getName());
        user1.setEmail(registration.getEmail());
        user1.setPassword(registration.getPassword());
        user1.setRole(registration.getRole());

        userRepository.save(user1);
        
        return "User Registered Successfully";
	}
	
}

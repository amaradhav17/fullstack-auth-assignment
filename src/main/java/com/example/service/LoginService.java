package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.LoginRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.security.JwtUtil;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String login(LoginRequest request) {
	    Optional<User> user = userRepository.findByEmail(request.getEmail());

	    if (user.isPresent()) {

	        User u = user.get();

	        if (u.getPassword().equals(request.getPassword())) {

	            return JwtUtil.generateToken(u.getEmail());

	        } else {
	            return "Invalid Password";
	        }

	    }

	    return "User Not Found";
	}
	

}

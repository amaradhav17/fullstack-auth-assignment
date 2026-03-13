package com.example.security;

import java.sql.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	 private static final String SECRET = "mysecretkeymysecretkeymysecretkeymysecretkey";

	    public static String generateToken(String email) {

	        return Jwts.builder()
	                .setSubject(email)
	                .setIssuedAt(new Date(0))
	                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
	                .signWith(SignatureAlgorithm.HS256, SECRET)
	                .compact();
	    }
	    
	    public static String extractEmail(String token) {

	        Claims claims = Jwts.parser()
	                .setSigningKey(SECRET)
	                .parseClaimsJws(token)
	                .getBody();

	        return claims.getSubject();
	    }

	
}
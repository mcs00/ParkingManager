package com.parking.service;

import java.util.HashMap;

import com.parking.dto.User;

public class AutheticationService {
	
	HashMap<String, User> dadesUsuaris = new HashMap<>();

	public AutheticationService() {
		dadesUsuaris.put("test1", new User("test1", "pass1", "First Test"));
		dadesUsuaris.put("test2", new User("test2", "pass2", "Second Test"));
		dadesUsuaris.put("test3", new User("test3", "pass3", "Third Test"));
	}
	
	public User getUsuari (String userId) {
		return dadesUsuaris.get(userId);
	
	}
	public boolean existUsuari (String userId) {
		return dadesUsuaris.containsKey(userId);
	
	}
	public boolean validUser (String userId, String userPass ) {
		
		if (dadesUsuaris.containsKey(userId)) {
			User usuari = dadesUsuaris.get(userId);
			String pass = usuari.getUserPassword();
			return (pass.equals(userPass));
		}else{
			return false;
		}
		
	
	}	
	

}
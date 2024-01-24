package com.thiagoreis.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagoreis.workshopmongo.domain.User;
import com.thiagoreis.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; 
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
}

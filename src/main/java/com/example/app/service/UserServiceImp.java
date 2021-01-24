package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> fetchAll() 
	{
		return userRepo.findAll();
	}
	
	public User findByEmail(String email) 
	{
		return userRepo.findByEmail(email);
	}
}

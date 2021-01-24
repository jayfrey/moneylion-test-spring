package com.example.app.service;

import java.util.List;

import com.example.app.model.User;

public interface UserService {
	
	public List<User> fetchAll();
	public User findByEmail(String email);
}

package com.example.service;

import com.example.model.User;

public interface UserService {
	
	public void addUser(User u);
	
	public User getUserByUsername(String username);

}

package com.example.dao;

import com.example.model.User;

public interface UserDao {

	public void addUser(User u);
	
	public User getUserByUsername(String username);
	
}

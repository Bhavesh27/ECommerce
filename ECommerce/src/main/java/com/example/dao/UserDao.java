package com.example.dao;

import com.example.model.User;

public interface UserDao {

	public void addUser(User u);
	
	public void updateUser(User user);
	
	public User getUserByUsername(String username);
	
	public User removeUser(String username);
	
}

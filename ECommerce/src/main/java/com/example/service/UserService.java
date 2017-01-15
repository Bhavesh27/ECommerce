package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
	
	public void addUser(User user);
	public User getUser(int userId);
	public User getUserByEmail(String email);
	public void updateUser(User user);
	public boolean deleteUser(int userId);
	public List<User> getAllUsers();

}

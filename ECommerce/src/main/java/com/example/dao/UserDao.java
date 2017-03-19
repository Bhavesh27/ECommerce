package com.example.dao;

import java.util.List;

import com.example.model.User;

public interface UserDao {

	public void addUser(User user);
	public User getUser(int userId);
	public User getUserByEmail(String email);
	public void updateUser(User user);
	public void deleteUser(User user);
	public List<User> getAllUsers();
	public List<User> getAllActiveUsers();
	public User getUserByUsername(String username);
	
}

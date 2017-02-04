package com.example.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;

@Service (value="userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public void addUser(User user) {
		try{
			userDao.addUser(user);
			}
		catch (HibernateException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		  
		//return user.getId();
	}

	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public boolean deleteUser(int userId) {
		return userDao.deleteUser(userId);
		//return true;
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
}

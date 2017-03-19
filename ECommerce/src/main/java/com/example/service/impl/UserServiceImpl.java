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

	public void deleteUser(User user) {
		userDao.deleteUser(user);
		//return true;
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub;
		//userDao.getAllUsers();
		//userDao.deleteUser();
		
	}

	@Override
	public List<User> getAllActiveUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllActiveUsers();
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(username);
	}
	
}

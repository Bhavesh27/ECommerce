
package com.example.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.model.User;

@Repository(value="userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	
	@Override
	public User removeUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addUser(User u) {
		sessionFactory.getCurrentSession().save(u);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return sessionFactory.getCurrentSession().get(User.class, username);
	}
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
	}

}

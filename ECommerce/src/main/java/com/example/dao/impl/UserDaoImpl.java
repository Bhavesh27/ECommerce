
package com.example.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.model.User;

@Repository(value="userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory session;
	
	public void addUser(User user) {
		session.getCurrentSession().save(user);
	}

	public User getUser(int userId) {
		return session.getCurrentSession().get(User.class, userId);
	}

	public User getUserByEmail(String email) {
		//return session.getCurrentSession().get(User.class, email);
		Criteria criteria = session.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		User user = (User) criteria.uniqueResult();
		return user;
	}

	public void updateUser(User user) {
		session.getCurrentSession().update(user);
	}

	public boolean deleteUser(int userId) {
		session.getCurrentSession().delete(userId);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return (List<User>) session.getCurrentSession().createQuery("from User").list();
	}
	
	
}

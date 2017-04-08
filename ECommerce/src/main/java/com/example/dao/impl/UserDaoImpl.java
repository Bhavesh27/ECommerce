
package com.example.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
		try{
		session.getCurrentSession().save(user);
		}
		catch (HibernateException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
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

	public void deleteUser(User user) {
		//User u = userDao.getUser(userId);
		session.getCurrentSession().delete(user);
		//return false;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return (List<User>) session.getCurrentSession().createQuery("from User where roleId=1").list();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllActiveUsers() {
		// TODO Auto-generated method stub
		return (List<User>) session.getCurrentSession().createQuery("from User where isactive=true and roleId=1").list();
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		Criteria criteria = session.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.like("username", username));
		return (User) criteria.uniqueResult();
	}	
}

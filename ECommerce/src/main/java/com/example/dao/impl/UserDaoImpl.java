
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
	private UserDao userDao;
	
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

	public boolean deleteUser(int userId) {
		User u = userDao.getUser(userId);
		session.getCurrentSession().delete(u);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return (List<User>) session.getCurrentSession().createQuery("from User").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllActiveUsers() {
		// TODO Auto-generated method stub
		return (List<User>) session.getCurrentSession().createQuery("from User where isactive=true").list();
	}
	
	
}

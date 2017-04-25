package com.example.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.OrderDao;
import com.example.model.CustomerOrder;

public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addOrder(CustomerOrder order) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public CustomerOrder getOrder(int orderId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(CustomerOrder.class,orderId);
	}

}

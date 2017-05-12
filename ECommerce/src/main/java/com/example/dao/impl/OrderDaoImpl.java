package com.example.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.OrderDao;
import com.example.model.CustomerOrder;

@Repository(value="orderDao")
@Transactional
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

	@Override
	public void updateOrder(CustomerOrder custOrder) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(custOrder);
	}

	@Override
	public boolean deleteOrder(CustomerOrder custOrder) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(custOrder);
		return false;
	}

}

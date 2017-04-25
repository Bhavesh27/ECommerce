package com.example.dao;

import com.example.model.CustomerOrder;

public interface OrderDao {

	public void addOrder(CustomerOrder order);
	public CustomerOrder getOrder(int orderId);

	
}

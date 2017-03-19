package com.example.dao;

import java.util.List;

import com.example.model.Cart;

public interface CartDao {

	public List<Cart> list();
	public Cart get(String id);
	public void saveOrUpdate(Cart Cart);
	public String delete(int id);
	public int getTotalAmount(String id);
	
}

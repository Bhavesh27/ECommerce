package com.example.dao;

import java.util.List;

import com.example.model.Cart;

public interface CartDao {

	public List<Cart> list(String username);
	public Cart getById(int id);
	public void Update(Cart Cart);
	public void delete(Cart cart);
	public int getTotalAmount(int id);
	public void addToCart(Cart cart);
	
}

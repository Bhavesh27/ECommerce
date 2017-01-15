package com.example.dao;

import java.util.List;

import com.example.model.Product;


public interface ProductDao {

	public void addProduct(Product product);
	public void updateProduct(Product product);
	public boolean deleteProduct(int product_id);
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	
}

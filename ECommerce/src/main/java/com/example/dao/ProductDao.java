package com.example.dao;

import java.util.List;

import com.example.model.Product;


public interface ProductDao {

	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	public List<Product> getProductByCategory(int categoryId);
	public Product getProductByName(String productName);
	public List<String> getProductListByName(String productName);
}

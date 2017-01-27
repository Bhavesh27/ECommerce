package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ProductDao;
import com.example.model.Product;
import com.example.service.ProductService;

@Service (value="productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.addProduct(product);
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.updateProduct(product);
	}

	public boolean deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(product_id);
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductById(id);
	}

}
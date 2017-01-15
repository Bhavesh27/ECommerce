package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.ProductDao;
import com.example.model.Product;

public class TestProducts {
	
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@SuppressWarnings("deprecation")
	@Test
	public void testMethod() {
		
		product = new Product();
		product.setName("laptop");
		product.setDescription("Best in class");
		product.setPrice(1528.0);
		product.setQuantity(100);
		
		productDao.addProduct(product);
		
		Product products = productDao.getProductById(2);
		
		assertEquals(1528.0, products.getPrice());
	}

}

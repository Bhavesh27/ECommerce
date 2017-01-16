package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.ProductDao;
import com.example.model.Product;


public class UnitTest {
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@SuppressWarnings("deprecation")
	@Test
	public void testProduct(){
		
		product = new Product();
		System.out.println("run test");
		product.setName("bahvesh");
        product.setDescription("Best");
        product.setPrice(1528.0);
        product.setQuantity(10);
        product.setProduct_id(2);
        
        productDao.addProduct(product);
     
        assertEquals(product.getPrice(), 1528.0);
        System.out.println("run test1");
	}
	
	
	
	

}

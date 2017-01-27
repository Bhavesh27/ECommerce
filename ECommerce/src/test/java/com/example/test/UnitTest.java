package com.example.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.configuration.HibernateConfiguration;
import com.example.dao.ProductDao;
import com.example.model.Product;

@WebAppConfiguration
public class UnitTest {
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.example");
		System.out.println("run test");
		
		context.refresh();
		
		productDao = (ProductDao) context.getBean("productDao");
		product = (Product) context.getBean("product");
		System.out.println("got Bean");
		
	}
	
	@Test
	public void testProduct(){
		
		//product = new Product();
		System.out.println("run test");
		product.setProduct_id(1);
		product.setName("bhavesh");
        product.setDescription("Best");
        product.setPrice(1528.0);
        product.setQuantity(10);
        product.setAuthor_name("jk rowling");
        
        productDao.addProduct(product);
     
        Assert.assertEquals(product.getName(), "bhavesh");
        System.out.println("run test1");
	}
}
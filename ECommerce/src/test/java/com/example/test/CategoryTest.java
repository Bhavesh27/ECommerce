package com.example.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.dao.CategoryDao;
import com.example.model.Category;


@WebAppConfiguration
public class CategoryTest {

	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.example");
		System.out.println("run test");
		
		context.refresh();
		
		categoryDao = (CategoryDao) context.getBean("categoryDao");
		category = (Category) context.getBean("category");
		System.out.println("got Bean");
		
	}
	
	@Test
	public void testProduct(){
		
		//product = new Product();
		System.out.println("run test");
		category.setCategory_id(1);
		category.setCategory_name("romance");
		category.setCategory_desc("this is just awesome");
     
        Assert.assertEquals(category.getCategory_name(), "romance");
        System.out.println("run test1");
	}
	
}

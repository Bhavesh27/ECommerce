package com.example.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.dao.CategoryDao;
import com.example.dao.ProductDao;
import com.example.dao.SupplierDao;
import com.example.model.Category;
import com.example.model.Product;
import com.example.model.Supplier;

@WebAppConfiguration
public class ProductTest {
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.example");
		System.out.println("run test");
		
		context.refresh();
		
		productDao = (ProductDao) context.getBean("productDao");
		product = (Product) context.getBean("product");
		
		category = (Category)context.getBean("category");
		categoryDao = (CategoryDao)context.getBean("categoryDao");
		
		supplierDao = (SupplierDao) context.getBean("supplierDao");
		supplier = (Supplier) context.getBean("supplier");
		
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
        //category.setCategory_id(1);
        product.setCategory(categoryDao.getCategoryById(1));
        //product.setSupplier(supplierDao.getSupplierById(1));
        
        productDao.addProduct(product);
     
        Assert.assertEquals(product.getName(), "bhavesh");
        System.out.println("run test1");
	}
}

package com.example.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.dao.SupplierDao;
import com.example.model.Supplier;

@WebAppConfiguration
public class SupplierTest {
	
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
		
		supplierDao = (SupplierDao) context.getBean("supplierDao");
		supplier = (Supplier) context.getBean("supplier");
		System.out.println("got Bean");
		
	}
	
	@Test
	public void testSupplier(){
		
		//product = new Product();
		System.out.println("run test");
		supplier.setSupplier_id(1);
		supplier.setSupplier_name("Cloudtail");
		supplier.setEmailid("email@xyz.com");
		supplier.setAddress("Delhi");
		supplier.setMobileno(1234567898);
     
		supplierDao.addSupplier(supplier);
		
        Assert.assertEquals(supplier.getAddress(), "Delhi");
        System.out.println("run test1");
	}
}

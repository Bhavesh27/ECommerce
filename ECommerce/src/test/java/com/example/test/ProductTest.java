package com.example.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.model.Product;
import com.example.service.ProductService;

public class ProductTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.example");
		context.refresh();
		
		System.out.println("Refresh done");
		
		ProductService productService = (ProductService) context.getBean("productService");
		Product product = (Product) context.getBean("product");
		System.out.println("got Bean");
		
		product = productService.getProductById(2);
		
		System.out.println(product.getName());
		
		context.close();
	}

}

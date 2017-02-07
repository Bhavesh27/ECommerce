package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	
}

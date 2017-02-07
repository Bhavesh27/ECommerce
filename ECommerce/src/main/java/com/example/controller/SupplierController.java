package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.service.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	
	
}

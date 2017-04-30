package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.google.gson.Gson;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value="/displayProduct-{categoryId}" , method = RequestMethod.GET)
    public String displayProduct(ModelMap model , @PathVariable("categoryId") int categoryId )
    {
    	model.addAttribute("DisplayProduct", "activ");
    	model.addAttribute("categories", categoryService.getAllCategorys());
    	model.addAttribute("books",productService.getProductByCategory(categoryId));
    	return "displayProduct";
    }
	
	@RequestMapping(value="/SearchController" , method = RequestMethod.GET)
    public void searchProduct(ModelMap model,@RequestParam("term") String productName, HttpServletResponse resp)
    {
    	List<String> list = productService.getProductListByName(productName.toUpperCase());
    	String json = new Gson().toJson(list);
    	try {
			resp.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value="/allProduct" , method=RequestMethod.GET)
    public String allProducts(ModelMap model)
    {
    	model.addAttribute("DisplayProduct","activ");
    	model.addAttribute("categories", categoryService.getAllCategorys());
    	model.addAttribute("books", productService.getAllProducts());
    	return "displayProduct";
    }
	
}
package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class ProductController  {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value="/displayProduct/productList/categorywise/{category_id}" , method = RequestMethod.GET)
    public String displayProduct(ModelMap model , @PathVariable("category_id") int categoryId )
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
    
    @RequestMapping(value="/displayProduct/productsList" , method=RequestMethod.GET)
    public String allProducts(ModelMap model)
    {
    	model.addAttribute("DisplayProduct","activ");
    	model.addAttribute("categories", categoryService.getAllCategorys());
    	model.addAttribute("books", productService.getAllProducts());
    	return "displayProduct";
    }
	
    @RequestMapping(value="/descriptionPage" , method = RequestMethod.GET)		
    public String toDescriptionPage(@RequestParam("book") String book , ModelMap model)		
      {		
          	model.addAttribute("user", getPrincipal());		
           	model.addAttribute("book",productService.getProductByName(book));		
           	model.addAttribute("categories", categoryService.getAllCategorys());		
           	return "productPage";		
       }
    
    public String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
    
}

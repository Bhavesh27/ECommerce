package com.example.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.controller.HelloWorldController;
import com.example.model.Category;
import com.example.model.Supplier;
import com.example.model.User;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.SupplierService;
import com.example.service.UserService;

@Controller 
class AdminController extends HelloWorldController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SupplierService supplierService;
	
    @Autowired
    Category category;
    
    @Autowired
    Supplier supplier;
    
	@RequestMapping(value = "/admin/dashboard", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		
		/*if(getPrincipal() == "anonymousUser")
		{
			return "redirect:/login";
		}*/
		
		model.addAttribute("user", getPrincipal());
		
		List<User> users = userService.getAllActiveUsers();
		model.addAttribute("users", users);
		
		/*model.addAttribute("edit", false);
	    model.addAttribute("new_category", new Category());
	    */
		
	    List<Category> categories = categoryService.getAllCategorys();
	    model.addAttribute("categories", categories);
	    model.addAttribute("suppliers", supplierService.getAllSuppliers().size());
	    model.addAttribute("products", productService.getAllProducts().size());
		
		return "admin/admin-dashboard";
	}
	
}

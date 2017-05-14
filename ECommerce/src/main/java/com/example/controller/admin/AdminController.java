package com.example.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Category;
import com.example.model.Supplier;
import com.example.model.User;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.SupplierService;
import com.example.service.UserService;

@Controller(value="adminController") 
class AdminController {
	
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
    
	@RequestMapping(value = "/admin/dashboard")
	public String adminPage(ModelMap model,HttpSession session) {
		
		if(getPrincipal() == "anonymousUser")
		{
			return "redirect:/login";
		}
		
		session.setAttribute("role", "ROLE_ADMIN");
		
		model.addAttribute("user", getPrincipal());
		
		List<User> users = userService.getAllActiveUsers();
		model.addAttribute("users", users.size());
		
		model.addAttribute("edit", false);
	    //model.addAttribute("new_category", new Category());
	    
		
	    List<Category> categories = categoryService.getAllCategorys();
	    model.addAttribute("categories", categories.size());
	    model.addAttribute("suppliers", supplierService.getAllSuppliers().size());
	    model.addAttribute("products", productService.getAllProducts().size());
		
		return "admin/admin-dashboard";
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

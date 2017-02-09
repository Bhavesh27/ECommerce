package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Category;
import com.example.model.Product;
import com.example.model.Supplier;
import com.example.model.User;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.SupplierService;
import com.example.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		
		List<User> users = userService.getAllActiveUsers();
		model.addAttribute("users", users);
		
		model.addAttribute("edit", false);
	    model.addAttribute("new_category", new Category());
	        
	    List<Category> categories = categoryService.getAllCategorys();
	    model.addAttribute("categories", categories);
		
		return "admin";
	}
	
	
	
	//USER PAGE CONTROLLER
	
	@RequestMapping(value="/delete-user-{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id)
	{
		userService.deleteUser(id);
		return "redirect:/admin";
		
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public String viewUsers(ModelMap model)
	{
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("user", getPrincipal());
		return "users";
		
	}
	
	//PRODUCT PAGE CONTROLLER
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String viewProduct(ModelMap model)
	{
		model.addAttribute("user", getPrincipal());
		
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		
		return "product";
		
	}
	
	
	
    /*@RequestMapping(value = "/Product", method = RequestMethod.GET)
    public String productPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
    	model.addAttribute("new_product",new Product());
    	
    	List<Category> category = categoryService.getAllCategorys();
    	model.addAttribute("category", category);
    	
    	List<Supplier> suppliers = supplierService.getAllSuppliers();
    	model.addAttribute("suppliers", suppliers);
    	
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        
        return "product";
    }*/
    
    @RequestMapping(value="/newProduct", method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("new_product") Product product)
    {
    	productService.addProduct(product);
    	return "redirect:/Product";
    }
    
    @RequestMapping(value="/edit-product-{product_id}", method = RequestMethod.POST)
    public String editProduct (@ModelAttribute("updateProduct")Product product)
    {
    	productService.updateProduct(product);
    	return "product";
    }
    
    @RequestMapping(value="/productEdit", method = RequestMethod.GET)
    public String productEdit (ModelMap model)
    {
    	model.addAttribute("updateProduct", new Product());
    	return "productedit";
    }
    
    @RequestMapping(value="/delete-product-{product_id}", method = RequestMethod.GET)
    public String deleteProduct (@PathVariable int product_id)
    {
    	//Product productId = productService.getProductById(product_id);
		productService.deleteProduct(product_id);
    	return "redirect:/product";
    }
    
    
    //CATEGORY CONTROLLER
    
    @RequestMapping(value="/category", method = RequestMethod.GET)
	public String viewCategory(ModelMap model)
	{
		model.addAttribute("user", getPrincipal());
		
		List<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);
		
		return "category";
		
	}
    
    @RequestMapping(value="/newCategory", method = RequestMethod.POST)
    public String addCategory (@ModelAttribute("new_category") Category category)
    {
    	categoryService.addCategory(category);
    	return "redirect:/admin";
    }
    
    @RequestMapping(value="/delete-category-{category_id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int category_id)
    {
    	categoryService.deleteCategory(categoryService.getCategoryById(category_id).getCategory_id());
    	return "redirect:/admin";
    }
    
    @RequestMapping(value="/edit-category-{category_id}" , method = RequestMethod.GET)
    public String editCategory(@PathVariable int category_id , ModelMap model)
    {
    	Category category = categoryService.getCategoryById(category_id);
    	model.addAttribute("category_id", category_id);
    	model.addAttribute("update_category", category);
    	model.addAttribute("categoryName", category.getCategory_name());
    	model.addAttribute("edit", true);
    	
    	List<User> users = userService.getAllActiveUsers();
        model.addAttribute("users", users);
        
        List<Category> categories = categoryService.getAllCategorys();
        model.addAttribute("categories", categories);
    	
    	return "admin";
    }
    
    @RequestMapping(value="/edit-category-{category_id}" , method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("update_category") Category category)
    {
    	categoryService.updateCategory(category);
    	return "redirect:/admin";
    }
    
    
    //SUPPLIER CONTROLLER
    
    
    @RequestMapping(value="/supplier", method = RequestMethod.GET)
	public String viewSupplier(ModelMap model)
	{
		model.addAttribute("user", getPrincipal());
		
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		model.addAttribute("suppliers",suppliers);
		
		return "supplier";
		
	}
    
    @RequestMapping(value="/Supplier" , method = RequestMethod.GET)
    public String supplierPage(ModelMap model)
    {
    	model.addAttribute("user", getPrincipal());
    	model.addAttribute("edit", false);
    	model.addAttribute("new_supplier", new Supplier());
    	model.addAttribute("suppliers", supplierService.getAllSuppliers());
    	return "supplier";
    }
    
    @RequestMapping(value="/delete-supplier-{supplier_id}" , method = RequestMethod.GET)
    public String deleteSupplier(@PathVariable int supplier_id)
    {
    	supplierService.deleteSupplier(supplierService.getSupplierById(supplier_id).getSupplier_id());
    	return "redirect:/Supplier";
    }
    
    @RequestMapping(value="/newSupplier" , method = RequestMethod.POST)
    public String addSupplier(@ModelAttribute("new_supplier") Supplier supplier)
    {
    	supplierService.addSupplier(supplier);
    	return "redirect:/Supplier";
    }
	
    @RequestMapping(value="/edit-supplier-{supplier_id}" , method = RequestMethod.GET)
    public String editSupplier(@PathVariable int supplier_id , ModelMap model)
    {
    	model.addAttribute("edit", true);
    	model.addAttribute("update_supplier" , supplierService.getSupplierById(supplier_id));
    	model.addAttribute("suppliers", supplierService.getAllSuppliers());
    	return "supplier";
    }
    
    @RequestMapping(value="/edit-supplier-{supplier_id}" , method = RequestMethod.POST)
    public String updateSupplier(@ModelAttribute("update_supplier") Supplier supplier)
    {
    	supplierService.updateSupplier(supplier);
    	return "redirect:/Supplier";
    }
	
	private String getPrincipal(){
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

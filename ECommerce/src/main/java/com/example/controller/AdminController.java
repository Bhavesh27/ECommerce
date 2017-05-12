package com.example.controller;
/*package com.example.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Category;
import com.example.model.Product;
import com.example.model.Supplier;
import com.example.model.User;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.SupplierService;
import com.example.service.UserService;

@Controller
public class Admin {

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
    
    Path path;
	
    //DashBoard
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		
		if(getPrincipal() == "anonymousUser")
		{
			return "redirect:/login";
		}
		
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
		User user = userService.getUser(id);
		userService.deleteUser(user);
		return "redirect:/users";
		
	}
	
	@RequestMapping(value="/change-user-status-{id}",method = RequestMethod.GET)
	public String changestatus(@PathVariable int id)
	{
		User user = userService.getUser(id);
		if (user.isActive()){
			user.setActive(false);
		} else{
			user.setActive(true);
		}
		userService.updateUser(user);
		
		return "redirect:/users";
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
		
		model.addAttribute("category", categoryService.getAllCategorys());
		model.addAttribute("suppliers", supplierService.getAllSuppliers());
		
		model.addAttribute("newProduct", new Product());
		
		return "product";
		
	}
	
	
	
    @RequestMapping(value = "/Product", method = RequestMethod.GET)
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
    }
    
    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("newProduct") Product product,HttpServletRequest request)
    {
    	
    	category=categoryService.getCategoryById(product.getCategory().getCategory_id());
    	supplier=supplierService.getSupplierById(product.getSupplier().getSupplier_id());
    	
    	product.setCategory(category);
    	product.setSupplier(supplier);
    	
    	productService.addProduct(product);
    	MultipartFile image = product.getProduct_image();
    	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
    	
    	path = Paths.get(rootDirectory + "/static/images/product/" + product.getProduct_name()+".png");
    	System.out.println(path);
    	if(image != null && !image.isEmpty())
    	{
    		try
    		{
    			image.transferTo(new File(path.toString()));
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	
    	return "redirect:/product";
    }
    
    @RequestMapping(value="/edit-product-{product_id}", method = RequestMethod.POST)
    public String editProduct (@ModelAttribute("updateProduct")Product product,HttpServletRequest request)
    {
    	category=categoryService.getCategoryById(product.getCategory().getCategory_id());
    	supplier=supplierService.getSupplierById(product.getSupplier().getSupplier_id());
    	    	
    	product.setCategory(category);
    	product.setSupplier(supplier);
    	
    	productService.updateProduct(product);
    	MultipartFile image = product.getProduct_image();
    	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
    	
    	path = Paths.get(rootDirectory + "/static/images/product/" + product.getProduct_name()+".png");
    	System.out.println(path);
    	if(image != null && !image.isEmpty())
    	{
    		try
    		{
    			image.transferTo(new File(path.toString()));
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	
    	return "redirect:/product";
    }
    
    @RequestMapping(value="/productEdit-{product_id}", method = RequestMethod.GET)
    public String productEdit (@PathVariable int product_id,ModelMap model)
    {
    	
    	
    	Product product = productService.getProductById(product_id);
    	model.addAttribute("product_id",product_id);
    	model.addAttribute("product_name",product.getProduct_name());
    	model.addAttribute("product_description",product.getProduct_desc());
    	model.addAttribute("product_author",product.getAuthor_name());
    	model.addAttribute("product_price",product.getProduct_price());
    	model.addAttribute("product_discount",product.getProduct_discount());
    	model.addAttribute("product_quantity",product.getProduct_quantity());
    	model.addAttribute("category",categoryService.getAllCategorys());
    	model.addAttribute("suppliers",supplierService.getAllSuppliers());
    	model.addAttribute("updateProduct", product);
    	return "productedit";
    }
    
    @RequestMapping(value="/delete-product-{product_id}", method = RequestMethod.GET)
    public String deleteProduct (@PathVariable int product_id)
    {
    	Product product = productService.getProductById(product_id);
		productService.deleteProduct(product);
    	return "redirect:/product";
    }
    
    
    //CATEGORY CONTROLLER
    
    @RequestMapping(value="/category", method = RequestMethod.GET)
	public String viewCategory(ModelMap model)
	{
		model.addAttribute("user", getPrincipal());
		
		List<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);
		
		model.addAttribute("newCategory", new Category());
		
		return "category";
		
	}
    
    @RequestMapping(value="/addCategory", method = RequestMethod.POST)
    public String addCategory (@ModelAttribute("newCategory") Category category)
    {
    	categoryService.addCategory(category);
    	return "redirect:/category";
    }
    
    @RequestMapping(value="/delete-category-{category_id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int category_id)
    {
    	Category category = categoryService.getCategoryById(category_id);
    	categoryService.deleteCategory(category);
    	return "redirect:/category";
    }
    
    
    @RequestMapping(value="/categoryEdit-{category_id}",method = RequestMethod.GET)
    public String categoryEdit(@PathVariable int category_id,ModelMap model)
    {
    	
    	Category category = categoryService.getCategoryById(category_id);
    	model.addAttribute("category_id", category_id);
    	model.addAttribute("categoryName", category.getCategory_name());
    	model.addAttribute("category_desc", category.getCategory_desc());
    	
    	model.addAttribute("updateCategory",category);
    	
    	return "categoryedit";
    	
    }
    
    @RequestMapping(value="/edit-category-{category_id}" , method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("updateCategory") Category category)
    {
    	categoryService.updateCategory(category);
    	return "redirect:/category";
    }
    
    
    //SUPPLIER CONTROLLER
    
    
    @RequestMapping(value="/supplier",method = RequestMethod.GET)
    public String supplierPage(ModelMap model){
    	
    	model.addAttribute("user", getPrincipal());
    	
    	List<Supplier> suppliers = supplierService.getAllSuppliers();
    	model.addAttribute("suppliers", suppliers);
    	
    	model.addAttribute("newSupplier", new Supplier());
    	
    	return "supplier";
    }
    
    @RequestMapping(value="/delete-supplier-{supplier_id}" , method = RequestMethod.GET)
    public String deleteSupplier(@PathVariable int supplier_id)
    {
    	Supplier supplier = supplierService.getSupplierById(supplier_id);
    	supplierService.deleteSupplier(supplier);
    	return "redirect:/supplier";
    }
    
    @RequestMapping(value="/supplierEdit-{supplier_id}",method = RequestMethod.GET)
    public String supplierEdit(@PathVariable int supplier_id,ModelMap model)
    {
    	
    	Supplier supplier = supplierService.getSupplierById(supplier_id);
    	model.addAttribute("supplier_id", supplier_id);
    	model.addAttribute("supplierName", supplier.getSupplier_name());
    	model.addAttribute("supplierAddress", supplier.getAddress());
    	model.addAttribute("supplierEmailId", supplier.getEmailid());
    	model.addAttribute("supplierMobileNo", supplier.getMobileno());
    	
    	model.addAttribute("updateSupplier",supplier);
    	
    	return "supplieredit";
    	
    }
    
    @RequestMapping(value="/addSupplier" , method = RequestMethod.POST)
    public String addSupplier(@ModelAttribute("newSupplier") Supplier supplier)
    {
    	supplierService.addSupplier(supplier);
    	return "redirect:/supplier";
    }
	
    @RequestMapping(value="/edit-supplier-{supplier_id}" , method = RequestMethod.GET)
    public String editSupplier(@PathVariable int supplier_id , ModelMap model)
    {
    	//model.addAttribute("edit", true);
    	model.addAttribute("update_supplier" , supplierService.getSupplierById(supplier_id));
    	model.addAttribute("suppliers", supplierService.getAllSuppliers());
    	return "supplier";
    }
    
    @RequestMapping(value="/edit-supplier-{supplier_id}" , method = RequestMethod.POST)
    public String updateSupplier(@ModelAttribute("update_supplier") Supplier supplier)
    {
    	supplierService.updateSupplier(supplier);
    	return "redirect:/supplier";
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
*/
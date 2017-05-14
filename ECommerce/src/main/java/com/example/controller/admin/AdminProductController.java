package com.example.controller.admin;

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
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.SupplierService;

@Controller
public class AdminProductController {

	
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
	
	@RequestMapping(value="/admin/products/product", method = RequestMethod.GET)
	public String viewProduct(ModelMap model)
	{
		model.addAttribute("user", getPrincipal());
		
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		
		model.addAttribute("category", categoryService.getAllCategorys());
		model.addAttribute("suppliers", supplierService.getAllSuppliers());
		
		model.addAttribute("newProduct", new Product());
		
		return "admin/products/product";
		
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
    
    @RequestMapping(value="/admin/products/add", method = RequestMethod.POST)
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
    	
    	return "redirect:/admin/products/product";
    }
    
    @RequestMapping(value="/admin/products/edit/{product_id}", method = RequestMethod.POST)
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
    	
    	return "redirect:/admin/products/product";
    }
    
    @RequestMapping(value="/admin/products/edit/{product_id}", method = RequestMethod.GET)
    public String productEdit (@PathVariable int product_id,ModelMap model)
    {
    	
    	
    	Product product = productService.getProductById(product_id);
    	/*model.addAttribute("product_id",product_id);
    	model.addAttribute("product_name",product.getProduct_name());
    	model.addAttribute("product_description",product.getProduct_desc());
    	model.addAttribute("product_author",product.getAuthor_name());
    	model.addAttribute("product_price",product.getProduct_price());
    	model.addAttribute("product_discount",product.getProduct_discount());
    	model.addAttribute("product_quantity",product.getProduct_quantity());
    	model.addAttribute("category",categoryService.getAllCategorys());
    	model.addAttribute("suppliers",supplierService.getAllSuppliers());*/
    	model.addAttribute("updProduct", product);
    	return "admin/products/productedit";
    }
    
    @RequestMapping(value="/admin/products/delete/{product_id}", method = RequestMethod.GET)
    public String deleteProduct (@PathVariable int product_id)
    {
    	Product product = productService.getProductById(product_id);
		productService.deleteProduct(product);
    	return "redirect:/admin/products/product";
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

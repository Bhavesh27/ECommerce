package com.example.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.controller.HelloWorldController;
import com.example.model.Category;
import com.example.service.CategoryService;

@Controller
public class AdminCategoryController extends HelloWorldController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/admin/categorys/category", method = RequestMethod.GET)
	public String viewCategory(ModelMap model)
	{
		model.addAttribute("user", getPrincipal());
		
		List<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);
		
		model.addAttribute("newCategory", new Category());
		
		return "admin/categorys/category";
		
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
	
	
	
}

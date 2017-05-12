package com.example.controller.admin;

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
import com.example.service.CategoryService;

@Controller(value="adminCategoryController")
public class AdminCategoryController{

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
    
    @RequestMapping(value="/admin/categorys/add", method = RequestMethod.POST)
    public String addCategory (@ModelAttribute("newCategory") Category category)
    {
    	categoryService.addCategory(category);
    	return "redirect:/admin/categorys/category";
    }
    
    @RequestMapping(value="/admin/categorys/delete/{category_id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int category_id)
    {
    	Category category = categoryService.getCategoryById(category_id);
    	categoryService.deleteCategory(category);
    	return "redirect:/admin/categorys/category";
    }
    
    
    @RequestMapping(value="/admin/categorys/edit/{category_id}",method = RequestMethod.GET)
    public String categoryEdit(@PathVariable int category_id,ModelMap model)
    {
    	
    	Category category = categoryService.getCategoryById(category_id);
    	/*model.addAttribute("category_id", category_id);
    	model.addAttribute("categoryName", category.getCategory_name());
    	model.addAttribute("category_desc", category.getCategory_desc());*/
    	
    	model.addAttribute("updCategory",category);
    	
    	return "admin/categorys/categoryedit";
    	
    }
    
    @RequestMapping(value="/admin/categorys/edit/{category_id}" , method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("updateCategory") Category category)
    {
    	categoryService.updateCategory(category);
    	return "redirect:/admin/categorys/category";
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

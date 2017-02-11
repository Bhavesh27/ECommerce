package com.example.service;

import java.util.List;

import com.example.model.Category;

public interface CategoryService {

	public void addCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(Category category);
	public List<Category> getAllCategorys();
	public Category getCategoryById(int category_id);
	
}

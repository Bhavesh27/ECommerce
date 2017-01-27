package com.example.dao;

import java.util.List;

import com.example.model.Category;

public interface CategoryDao {
	
	
	public void addCategory(Category category);
	public void updateCategory(Category category);
	public boolean deleteCategory(int category_id);
	public List<Category> getAllCategorys();
	public Category getCategoryById(int category_id);

}

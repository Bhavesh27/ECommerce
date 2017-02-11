package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CategoryDao;
import com.example.model.Category;
import com.example.service.CategoryService;

@Service (value="categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.addCategory(category);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.updateCategory(category);
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.deleteCategory(category);
	}

	@Override
	public List<Category> getAllCategorys() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategorys();
	}

	@Override
	public Category getCategoryById(int category_id) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryById(category_id);
	}

}

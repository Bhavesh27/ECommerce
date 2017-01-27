package com.example.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CategoryDao;
import com.example.model.Category;

@Repository(value="categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(category);
		
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(category);
	}

	@Override
	public boolean deleteCategory(int category_id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(category_id);
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategorys() {
		// TODO Auto-generated method stub
		return (List<Category>)sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Override
	public Category getCategoryById(int category_id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class,category_id);
	}

}

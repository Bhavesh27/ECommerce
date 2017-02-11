package com.example.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ProductDao;
import com.example.model.Product;


@Repository(value="productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	ProductDao productDao;

	
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(product);
		
	}


	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().update(product);
		
	}


	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		//Product p = productDao.getProductById(product_id);
		sessionFactory.getCurrentSession().delete(product);
		//return false;
	}

	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	
	public Product getProductById(int id) {
		
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}
	
	
}

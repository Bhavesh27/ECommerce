package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		//return (List<Product>) sessionFactory.getCurrentSession().createQuery("from Product").list();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		return (List<Product>) criteria.list();
	}

	
	public Product getProductById(int id) {
		
		System.out.println("here");
		return sessionFactory.getCurrentSession().get(Product.class, id);
		/*Criteria criteria  = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.like("product_id", id));
		return (Product)criteria.uniqueResult();*/
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductByCategory(int categoryId) {
		// TODO Auto-generated method stub
		//return (List<Product>) sessionFactory.getCurrentSession().createQuery("from Product  where category_id  ="+ categoryId).list();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.like("category_id", categoryId));
		return (List<Product>) criteria.list();
	}


	@Override
	public Product getProductByName(String productName) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("name",productName));
		Product product = (Product)criteria.uniqueResult();
		return product;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> getProductListByName(String productName) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		//criteria.add(Restrictions.like("name",productName+"%"));
		criteria.add(Restrictions.like("product_name", productName + "%").ignoreCase());
		List<Product> products = (List<Product>)criteria.list();
		List<String> productsName = new ArrayList<String>();
		for(Product product:products){
			productsName.add(product.getProduct_name());
			System.out.println(product.getProduct_name());
		}
		 return productsName;
	}
	
	
}

package com.example.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.SupplierDao;
import com.example.model.Supplier;

@Repository(value="supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	SupplierDao supplierDao;
	
	
	public void addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(supplier);
	}

	
	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(supplier);
	}

	
	public void deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		 //Supplier s = supplierDao.getSupplierById(supplier_id);
		 sessionFactory.getCurrentSession().delete(supplier);
		 //return false;
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return (List<Supplier>) sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	
	public Supplier getSupplierById(int supplier_id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Supplier.class, supplier_id);
	}

}

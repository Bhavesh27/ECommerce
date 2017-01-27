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
	
	@Override
	public void addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(supplier);
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(supplier);
	}

	@Override
	public boolean deleteSupplier(int supplier_id) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().delete(supplier_id);
		 return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return (List<Supplier>) sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	@Override
	public Supplier getSupplierById(int supplier_id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Supplier.class, supplier_id);
	}

}

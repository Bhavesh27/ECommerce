package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.SupplierDao;
import com.example.model.Supplier;
import com.example.service.SupplierService;

@Service (value="supplierService")
@Transactional
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierDao supplierDao;

	@Override
	public void addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierDao.addSupplier(supplier);
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierDao.updateSupplier(supplier);
	}

	@Override
	public void deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierDao.deleteSupplier(supplier);
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return supplierDao.getAllSuppliers();
	}

	@Override
	public Supplier getSupplierById(int supplier_id) {
		// TODO Auto-generated method stub
		return supplierDao.getSupplierById(supplier_id);
	}
}

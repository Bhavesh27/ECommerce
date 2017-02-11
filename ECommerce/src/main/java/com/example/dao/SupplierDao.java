package com.example.dao;

import java.util.List;

import com.example.model.Supplier;

public interface SupplierDao {

	public void addSupplier(Supplier supplier);
	public void updateSupplier(Supplier supplier);
	public void deleteSupplier(Supplier supplier);
	public List<Supplier> getAllSuppliers();
	public Supplier getSupplierById(int supplier_id);
	
}

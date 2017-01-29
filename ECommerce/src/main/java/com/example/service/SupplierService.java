package com.example.service;

import java.util.List;

import com.example.model.Supplier;

public interface SupplierService {

	public void addSupplier(Supplier supplier);
	public void updateSupplier(Supplier supplier);
	public boolean deleteSupplier(int supplier_id);
	public List<Supplier> getAllSuppliers();
	public Supplier getSupplierById(int supplier_id);
	
}

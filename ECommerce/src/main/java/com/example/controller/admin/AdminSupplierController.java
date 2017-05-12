package com.example.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Supplier;
import com.example.service.SupplierService;

@Controller(value="adminSupplierController")
public class AdminSupplierController{
	
    //SUPPLIER CONTROLLER
    
	@Autowired
	SupplierService supplierService;
    
    @RequestMapping(value="/admin/suppliers/supplier",method = RequestMethod.GET)
    public String supplierPage(ModelMap model){
    	
    	model.addAttribute("user", getPrincipal());
    	
    	List<Supplier> suppliers = supplierService.getAllSuppliers();
    	model.addAttribute("suppliers", suppliers);
    	
    	model.addAttribute("newSupplier", new Supplier());
    	
    	return "admin/suppliers/supplier";
    }
    
    @RequestMapping(value="/admin/suppliers/delete/{supplier_id}" , method = RequestMethod.GET)
    public String deleteSupplier(@PathVariable int supplier_id)
    {
    	Supplier supplier = supplierService.getSupplierById(supplier_id);
    	supplierService.deleteSupplier(supplier);
    	return "redirect:/admin/suppliers/supplier";
    }
    
    @RequestMapping(value="/admin/suppliers/edit/{supplier_id}",method = RequestMethod.GET)
    public String supplierEdit(@PathVariable int supplier_id,ModelMap model)
    {
    	
    	Supplier supplier = supplierService.getSupplierById(supplier_id);
    	/*model.addAttribute("supplier_id", supplier_id);
    	model.addAttribute("supplierName", supplier.getSupplier_name());
    	model.addAttribute("supplierAddress", supplier.getAddress());
    	model.addAttribute("supplierEmailId", supplier.getEmailid());
    	model.addAttribute("supplierMobileNo", supplier.getMobileno());*/
    	
    	model.addAttribute("updSupplier",supplier);
    	
    	return "admin/suppliers/supplieredit";
    	
    }
    
    @RequestMapping(value="/admin/suppliers/add" , method = RequestMethod.POST)
    public String addSupplier(@ModelAttribute("newSupplier") Supplier supplier)
    {
    	supplierService.addSupplier(supplier);
    	return "redirect:/admin/suppliers/supplier";
    }
	
   /* @RequestMapping(value="/edit-supplier-{supplier_id}" , method = RequestMethod.GET)
    public String editSupplier(@PathVariable int supplier_id , ModelMap model)
    {
    	//model.addAttribute("edit", true);
    	model.addAttribute("update_supplier" , supplierService.getSupplierById(supplier_id));
    	model.addAttribute("suppliers", supplierService.getAllSuppliers());
    	return "supplier";
    }*/
    
    @RequestMapping(value="/admin/suppliers/edit/{supplier_id}" , method = RequestMethod.POST)
    public String updateSupplier(@ModelAttribute("update_supplier") Supplier supplier)
    {
    	supplierService.updateSupplier(supplier);
    	return "redirect:/admin/suppliers/supplier";
    }
    
    public String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}

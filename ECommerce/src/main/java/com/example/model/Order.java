/*package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Order {

	@Id		
	@Column		
	@GeneratedValue(strategy = GenerationType.AUTO)		
	int order_id;		
	  			
	@Column		
	String username;		
	
	@Column
	List<String> product_name;		
	
	@Min(0)		
	int quantity;		
	
	@Column
	int grand_total;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getProduct_name() {
		return product_name;
	}

	public void setProduct_name(List<String> product_name) {
		this.product_name = product_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getGrand_total() {
		return grand_total;
	}

	public void setGrand_total(int grand_total) {
		this.grand_total = grand_total;
	}		

	
}
*/
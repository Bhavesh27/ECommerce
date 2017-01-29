package com.example.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Product")
@Component
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int product_id;
	@Column
	public String name;
	@Column
	public String description;
	@Column
	public double price;
	@Column
	public int quantity;
	@Column
	String author_name;
	
	//Mapping
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToMany
	@JoinTable(name="product_supplier",joinColumns={@JoinColumn(name="product_id")},inverseJoinColumns={@JoinColumn(name="supplier_id")})
	private Supplier supplier;
	
	public int getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
}

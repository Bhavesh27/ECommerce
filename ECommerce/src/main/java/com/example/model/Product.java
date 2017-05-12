package com.example.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
	public String product_name;
	@Column
	public String product_desc;
	@Column
	public double Product_price;
	@Column
	public int product_quantity;
	@Column
	String author_name;
	@Column
    int product_discount=0;
	
	@Transient
	MultipartFile product_image;
	
	public MultipartFile getProduct_image() {
		return product_image;
	}
	public void setProduct_image(MultipartFile product_image) {
		this.product_image = product_image;
	}
	
	//Mapping
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	//@JoinTable(name="product_supplier",joinColumns={@JoinColumn(name="product_id")},inverseJoinColumns={@JoinColumn(name="supplier_id")})
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
    private Set<Cart> cart;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
    private Set<Wishlist> wishlist;
	
	public Set<Wishlist> getWishlist() {
		return wishlist;
	}
	public void setWishlist(Set<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}
	public Set<Cart> getCart() {
		return cart;
	}
	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
	
	
	public int getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public double getProduct_price() {
		return Product_price;
	}
	public void setProduct_price(double product_price) {
		Product_price = product_price;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public int getProduct_discount() {
		return product_discount;
	}
	public void setProduct_discount(int product_discount) {
		this.product_discount = product_discount;
	}
	
	
}

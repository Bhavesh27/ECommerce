package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Wishlist implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @Column
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 int wishlist_id;
	 @Column
	 String username;
	 @Column
	 String product_name;
	 @Column
	 String author;
	 @Column
	 String description;
	 
	 //Mapping
	 
	    @ManyToOne(optional = false)
		@JoinColumn(name = "user_id",referencedColumnName="user_id")
		private User user;
		
		@ManyToOne(optional = false)
		@JoinColumn(name = "productId",referencedColumnName="product_id")
		private Product product;
	
		
		
	 public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
	public int getWishlist_id() {
		return wishlist_id;
	}
	public void setWishlist_id(int wishlist_id) {
		this.wishlist_id = wishlist_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	 
	 
}

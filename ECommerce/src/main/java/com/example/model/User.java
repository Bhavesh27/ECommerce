package com.example.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class User implements Serializable{
 
	private static final long serialVersionUID = -1472066795342727103L;
	
	@Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int user_id;
   
	@Column(unique=true)
    public String username;
   
    @Column
    public String password;
   
    @Column
    public boolean isActive=false;
    
    @Column
    public int roleId=1;
    
    @Column(unique=true)
    public String email;
   
    @Column(name="Mobile_No",unique=true)
    public String mobileno;
    
    @Column(name="Name")
    public String name;
    
    @Column(name="Address")
    public String address;
    
    @Transient
    public MultipartFile image;

    //Mapping
    
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    private Set<Cart> cart;
    
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
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
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}

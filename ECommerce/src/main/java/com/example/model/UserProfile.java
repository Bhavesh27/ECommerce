/*package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table 
public class UserProfile {
    
	@Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	@Column
	String firstName;
	@Column
	String lastName;
	@Column
	String city;
	@Column
	String country;
	@Column
	String address;
	@Column(unique=true)
	long mobileno;
	@Transient
	MultipartFile user_image;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public MultipartFile getUser_image() {
		return user_image;
	}
	public void setUser_image(MultipartFile user_image) {
		this.user_image = user_image;
	}
}
*/
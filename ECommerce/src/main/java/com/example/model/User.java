package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
 
	private static final long serialVersionUID = -1472066795342727103L;
	@Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
    @Column(unique=true)
	private String username;
    @Column
	private String password;
    @Column
    private boolean isActive=true;
    @Column
    //GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId=1;
    
    public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	private String email;
    private String mobile;
    private String name;
  
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
}

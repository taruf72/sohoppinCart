package com.shopingcart.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Enter Name")
	@Size(min=3, max=20, message="username must have 3 Caracter")
	private String username;
	private String role;
	
	@NotEmpty(message="Enter  Password")
	private String password;
	
	@NotEmpty(message="Enter Email ")
	@Email(message="Enter Valid Email")
	private String email;
	
	@NotEmpty(message="Enter Mobile Number")
	@Pattern(regexp = "^\\d{10}$",message="Enter Valid Mobile Number")
	private String mobile;
	
	
	
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserEntity(int id, String username, String role, String password) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
		this.password = password;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
		// TODO Auto-generated constructor stub
	}
	
	
//	@ElementCollection
//	@CollectionTable(name="rolestab",
//	joinColumns=@JoinColumn(name = "uid")
//			)
//	private List<String> roles;


	
	
	


	



	


	
	
	
	
	
	 
	
	



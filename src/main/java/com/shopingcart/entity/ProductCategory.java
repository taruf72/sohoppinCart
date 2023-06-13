package com.shopingcart.entity;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int catId;
	private String catName;
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public ProductCategory(int catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	
	
	

	


}

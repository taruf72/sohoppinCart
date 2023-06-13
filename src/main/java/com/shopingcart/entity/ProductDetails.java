package com.shopingcart.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ProductDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int proDetailsId;
	private int catRefId;
	private int subCatRefId;
	private String proName;
	private String proPrice;
	
	public int getProDetailsId() {
		return proDetailsId;
	}
	public void setProDetailsId(int proDetailsId) {
		this.proDetailsId = proDetailsId;
	}
	public int getCatRefId() {
		return catRefId;
	}
	public void setCatRefId(int catRefId) {
		this.catRefId = catRefId;
	}
	public int getSubCatRefId() {
		return subCatRefId;
	}
	public void setSubCatRefId(int subCatRefId) {
		this.subCatRefId = subCatRefId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProPrice() {
		return proPrice;
	}
	public void setProPrice(String proPrice) {
		this.proPrice = proPrice;
	}

	public ProductDetails(int proDetailsId, int catRefId, int subCatRefId, String proName, String proPrice
			) {
		super();
		this.proDetailsId = proDetailsId;
		this.catRefId = catRefId;
		this.subCatRefId = subCatRefId;
		this.proName = proName;
		this.proPrice = proPrice;
		
	}
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

	
	
	
}

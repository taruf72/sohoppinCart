package com.shopingcart.entity;

public class SaveAllData {
	
	
	private String catName;
	private String subCatName;
	private String proName;
	private String proPrice;
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
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
	public SaveAllData(String catName, String subCatName, String proName, String proPrice) {
		super();
		this.catName = catName;
		this.subCatName = subCatName;
		this.proName = proName;
		this.proPrice = proPrice;
	}
	public SaveAllData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}

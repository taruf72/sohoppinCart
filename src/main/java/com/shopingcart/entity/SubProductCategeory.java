package com.shopingcart.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class SubProductCategeory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int subCatId;
	private int catRefId;
	private String subCatName;
	
	
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public int getCatRefId() {
		return catRefId;
	}
	public void setCatRefId(int catRefId) {
		this.catRefId = catRefId;
	}
	public String getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}
	public SubProductCategeory(int subCatId, int catRefId, String subCatName) {
		super();
		this.subCatId = subCatId;
		this.catRefId = catRefId;
		this.subCatName = subCatName;
	}
	public SubProductCategeory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

	
	

}

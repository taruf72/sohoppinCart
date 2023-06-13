package com.shopingcart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shopingcart.entity.ProductCategory;

public interface ProductCategoryService {

	ResponseEntity<?> saveProCat(ProductCategory productCategory);

	ProductCategory findByCatName(String catName);

	List<ProductCategory> getallCategory();

	ResponseEntity<?> deleteOneCat(int id);

	//ProductCategory findBySubCatName(String catName);

	 

}

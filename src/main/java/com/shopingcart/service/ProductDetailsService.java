package com.shopingcart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shopingcart.entity.ProductDetails;

public interface ProductDetailsService {

	ResponseEntity<?> saveProDetails(ProductDetails productDetails);

	 ResponseEntity<?> getDataByid(int id);

	ResponseEntity<?> deleteByProId(int id);

	ResponseEntity<?> getAllData();

	List<ProductDetails> getAllProduct(int id);

	ResponseEntity<?> deleteById(int id);
	
	
	


}

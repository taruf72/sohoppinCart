package com.shopingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shopingcart.entity.ProductCategory;
import com.shopingcart.entity.ProductDetails;
import com.shopingcart.entity.SubProductCategeory;
import com.shopingcart.service.ProductCategoryService;
import com.shopingcart.service.ProductDetailsService;
import com.shopingcart.service.SubCategoryService;
import com.shopingcart.service.UserSignupService;

@RestController
public class CostumerController {
	
	@Autowired
	private ProductDetailsService proDetailsService;
	@Autowired
	private ProductCategoryService proCatService;
	@Autowired
	private SubCategoryService subCatService;
	@Autowired
	private UserSignupService adminSignup;
	
	
	
	// CUSTOMER AND ADMIN CAN SEE ALL CATEGORY 
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<?> getAllCategory(){
		
		List<ProductCategory> catList = proCatService.getallCategory();
		return new ResponseEntity<>(catList,HttpStatus.OK);
		
	}
	
	// CUSTOMER AND ADMIN CAN SEE ALL SUB-CATEGORY
	
	@GetMapping("/subcategory/{id}")
	public ResponseEntity<?> getAllSubCat(@PathVariable int id){
		ResponseEntity<?> subProCat = subCatService.getAllSubCat(id);
		return subProCat;
		
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getAllProduct(@PathVariable int id){
		
		List<ProductDetails> proDetail=proDetailsService.getAllProduct(id);
		return new ResponseEntity<>(proDetail,HttpStatus.OK);
		
	}

}

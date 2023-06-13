package com.shopingcart.service;



import org.springframework.http.ResponseEntity;

import com.shopingcart.entity.SubProductCategeory;

public interface SubCategoryService {

	ResponseEntity<?> saveSubProduct(SubProductCategeory subProductCategory);

	ResponseEntity<?> getAllSubCat(int id);

	SubProductCategeory findBySubCatName(String subCatName);

	ResponseEntity<?> deleteOneSubCat(int id);


}

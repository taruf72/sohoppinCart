package com.shopingcart.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopingcart.entity.ProductCategory;
import com.shopingcart.entity.ProductDetails;
import com.shopingcart.entity.SaveAllData;
import com.shopingcart.entity.SubProductCategeory;
import com.shopingcart.entity.UserEntity;
import com.shopingcart.service.ProductCategoryService;
import com.shopingcart.service.ProductDetailsService;
import com.shopingcart.service.SaveAllService;
import com.shopingcart.service.SubCategoryService;
import com.shopingcart.service.UserSignupService;

@RestController
public class ProductDetailController {
	@Autowired
	private ProductDetailsService proDetailsService;
	@Autowired
	private ProductCategoryService proCatService;
	@Autowired
	private SubCategoryService subCatService;
	@Autowired
	private UserSignupService adminSignup;
	@Autowired
	private SaveAllService saveAllRecord;

	int catId;
	int subCatId;

	// ADMIN CAN ADD-CATEGORY
	@PostMapping("/addCategory")
	public ResponseEntity<?> saveCat(@RequestBody ProductCategory proCat) {
		String name = "admin";
		ProductCategory checkCat = proCatService.findByCatName(proCat.getCatName());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserEntity user = adminSignup.findByUsername(auth.getName());

		if (name.equals(user.getRole())) {

			if (checkCat == null) {

				ResponseEntity<?> saveProCat = proCatService.saveProCat(proCat);
				catId = proCat.getCatId();
				return saveProCat;
			} else {
				catId = checkCat.getCatId();

				Map<String, String> map = new LinkedHashMap<>();
				map.put("status", "true");
				map.put("message", " Save Category");
				return new ResponseEntity<>(map, HttpStatus.OK);

			}
		} else {
			Map<String, String> map = new LinkedHashMap<>();
			map.put("status", "fail");
			map.put("message", "Only Admin Can Add Category");
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}

	// ADMIN ADD SUB-CATEGORY
	@PostMapping("/addSubCat")
	public ResponseEntity<?> saveSubPro(@RequestBody SubProductCategeory subProCat) {

		SubProductCategeory subProCate = subCatService.findBySubCatName(subProCat.getSubCatName());

		String name = "admin";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserEntity user = adminSignup.findByUsername(auth.getName());

		if (name.equals(user.getRole())) {

			if (subProCate == null) {

				subProCat.setCatRefId(catId);
				ResponseEntity<?> saveSubProduct = subCatService.saveSubProduct(subProCat);
				subCatId = subProCat.getSubCatId();
				return saveSubProduct;
			}

			else {

				subProCat.setCatRefId(catId);
				subCatService.saveSubProduct(subProCat);
				subCatId = subProCat.getSubCatId();
				Map<String, String> map = new LinkedHashMap<>();
				map.put("status", "True");
				map.put("message", "Save SubCatagory");
				return new ResponseEntity<>(map,  HttpStatus.OK);
			}
		} else {
			Map<String, String> map = new LinkedHashMap<>();
			map.put("status", "fail");
			map.put("message", "Only Admin Can Enter SubCatagory");
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}

	// ADMIN CAN ADD PRODUCT
	@PostMapping("/addPrduct")
	public ResponseEntity<?> saveProDetails(@RequestBody ProductDetails productDetails) {

		String name = "admin";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserEntity user = adminSignup.findByUsername(auth.getName());

		if (name.equals(user.getRole())) {

			productDetails.setCatRefId(catId);
			productDetails.setSubCatRefId(subCatId);
			ResponseEntity<?> save = proDetailsService.saveProDetails(productDetails);
			return save;
		}

		else {
			Map<String, String> map = new LinkedHashMap<>();
			map.put("status", "fail");
			map.put("message", "Only Admin Can Add Product");
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}

	// ADMIN GET RECORD BY ID
	@GetMapping("/getProductById/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id) {

		ResponseEntity<?> dataByid = proDetailsService.getDataByid(id);
		return dataByid;

	}

	// ADMIN CAN DELETE CATEGORY WITH SUBCATEGORY AND ALLPRODUCT RECORD BY ID
	@DeleteMapping("/deleteCatProSubProById/{id}")
	public ResponseEntity<?> deletById(@PathVariable int id) {

		String name = "admin";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserEntity user = adminSignup.findByUsername(auth.getName());

		if (name.equals(user.getRole())) {

			ResponseEntity<?> deleteData = proDetailsService.deleteById(id);
			return deleteData;
		}

		else {

			Map<String, String> map = new LinkedHashMap<>();
			map.put("status", "fail");
			map.put("message", "only admin can  Delete Recorde");
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	// ADMIN DELETE ONE PRODUCT
	@DeleteMapping("/deleteOneProduct/{id}")
	public ResponseEntity<?> deleteOneProduct(@PathVariable int id) {

		String name = "admin";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserEntity user = adminSignup.findByUsername(auth.getName());

		if (name.equals(user.getRole())) {

			ResponseEntity<?> deleteOnePro = proDetailsService.deleteByProId(id);

			return deleteOnePro;
		} else {

			Map<String, String> map = new LinkedHashMap<>();
			map.put("status", "fail");
			map.put("message", "only admin can  Delete Recorde");
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}

	// ADMIN DELETE ONE CATEGORY
	@DeleteMapping("/deleteOneCat/{id}")
	public ResponseEntity<?> deleteOneCategory(@PathVariable int id) {

		String name = "admin";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserEntity user = adminSignup.findByUsername(auth.getName());

		if (name.equals(user.getRole())) {

			ResponseEntity<?> deleteOnePro = proCatService.deleteOneCat(id);

			return deleteOnePro;
		} else {

			Map<String, String> map = new LinkedHashMap<>();
			map.put("status", "fail");
			map.put("message", "only admin can  Delete Recorde");
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}
	
	
	// ADMIN DELETE ONE SUBCATEGORY
	@DeleteMapping("/deleteOneSubCat/{id}")
	public ResponseEntity<?> deleteOneSubCat(@PathVariable int id){
		
		String name = "admin";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserEntity user = adminSignup.findByUsername(auth.getName());

		if (name.equals(user.getRole())) {

			ResponseEntity<?> deleteOnePro = subCatService.deleteOneSubCat(id);

			return deleteOnePro;
		}
		else {

			Map<String, String> map = new LinkedHashMap<>();
			map.put("status", "fail");
			map.put("message", "only admin can  Delete Recorde");
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
		
		
		
		
		
	}
	
	
	// GET ALL RECORD
	@GetMapping("/getAllRecord")
	public ResponseEntity<?> getAllData() {

		String name = "admin";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserEntity user = adminSignup.findByUsername(auth.getName());

		if (name.equals(user.getRole())) {
			ResponseEntity<?> getRecord = proDetailsService.getAllData();
			return getRecord;
		}

		else {
			Map<String, String> map = new LinkedHashMap<>();
			map.put("status", "fail");
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}

	// ADMIN SAVE ALL DATA LIKE CATEGORY SUB-CATEGORY PRODUCTDETAILS
	@PostMapping("/saveAll")
	public ResponseEntity<?> saveAll(@RequestBody SaveAllData saveAll) {

		String name = "admin";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserEntity user = adminSignup.findByUsername(auth.getName());

		if (name.equals(user.getRole())) {

			saveAllRecord.saveAllRecord(saveAll);
			return new ResponseEntity<>("save Data", HttpStatus.OK);
		} else {
			Map<String, String> map = new LinkedHashMap<>();
			map.put("status", "fail");
			map.put("message", "only admin can Store data");
			return new ResponseEntity<>(map, HttpStatus.OK);

		}

	}

}

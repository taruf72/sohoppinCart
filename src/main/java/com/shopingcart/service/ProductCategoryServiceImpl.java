package com.shopingcart.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopingcart.entity.ProductCategory;
import com.shopingcart.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository proCatRepo;

	@Override
	public ResponseEntity<?> saveProCat(ProductCategory productCategory) {
		Map<String, Object> map = new LinkedHashMap<>();
		ProductCategory save = proCatRepo.save(productCategory);
		map.put("Status", "True");
		map.put("Data", save);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@Override
	public ProductCategory findByCatName(String catName) {
		ProductCategory findByCatName = proCatRepo.findByCatName(catName);

		return findByCatName;
	}

	@Override
	public List<ProductCategory> getallCategory() {

		List<ProductCategory> findAll = proCatRepo.findAll();
		return findAll;
	}

	@Override
	public ResponseEntity<?> deleteOneCat(int id) {
		Map<String,String> map=new LinkedHashMap<>();
		ProductCategory getCatById = proCatRepo.getByCatId(id);

		if (getCatById == null) {
			map.put("Status", "Fail");
			map.put("message", "Id not Exists");
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		} else {
			proCatRepo.deleteById(id);
			map.put("Status", "True");
			map.put("message", "Record delete Successfully");
			return new ResponseEntity<>(map, HttpStatus.OK);

		}

		
	}

}

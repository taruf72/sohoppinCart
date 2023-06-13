package com.shopingcart.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopingcart.entity.ProductCategory;
import com.shopingcart.entity.ProductDetails;
import com.shopingcart.entity.SubProductCategeory;
import com.shopingcart.repository.ProductCategoryRepository;
import com.shopingcart.repository.ProductDetailsRepository;
import com.shopingcart.repository.SubCategoryProductRepository;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {
	
	@Autowired
	private ProductDetailsRepository proDetailRepo;
	@Autowired
	private ProductCategoryRepository proCatRepo;
	@Autowired
	private SubCategoryProductRepository subCatRepo;
	

	@Override
	public ResponseEntity<?> saveProDetails(ProductDetails productDetails) {
		Map<String,Object> map=new LinkedHashMap<>();
		ProductDetails save = proDetailRepo.save(productDetails);
		map.put("Status", "True");
		map.put("Data", save);
		return new ResponseEntity<>(save,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getDataByid(int id) {
		Map<String,Object> map=new LinkedHashMap<>();
		ProductDetails getbyId = proDetailRepo.getByProDetailsId(id);
		if(getbyId==null) {
			map.put("Status", "Fail");
			map.put("message", "Id not Exists");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		map.put("Status", "True");
		map.put("Data",getbyId );
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		
	}

	@Override
	public ResponseEntity<?> deleteByProId(int id) {
		Map<String,Object> map=new LinkedHashMap<>();
		ProductDetails getProById = proDetailRepo.getByProDetailsId(id);
		
		if(getProById==null) {
			map.put("Status", "Fail");
			map.put("message", "Id not Exists");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}else {
			proDetailRepo.deleteById(id);
			
		map.put("Status", "True");
		map.put("message", "Record delete Successfully");
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		
	}
		}
	
	
	@Override
	public ResponseEntity<?> deleteById(int id){
		
		Map<String,String> map=new LinkedHashMap<>();
		List<ProductDetails> findAllCatRefId = proDetailRepo.findAllByCatRefId(id);
		List<SubProductCategeory> findAllSubCatRefId = subCatRepo.findAllByCatRefId(id);


		
		if(findAllCatRefId.isEmpty()) {
			
			map.put("Status", "Fail");
			map.put("message", "id Not Exists");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}else {
			
			proDetailRepo.deleteAll(findAllCatRefId);
			subCatRepo.deleteAll(findAllSubCatRefId);
			proCatRepo.deleteById(id);
			
			map.put("Status", "True");
			map.put("message", "Delete Successfully");
			return new ResponseEntity<>(map,HttpStatus.OK);
			
		}
		
		
	}
	
	@Override
	public ResponseEntity<?> getAllData() {
		Map<String,Object> map=new LinkedHashMap<>();
		List<ProductDetails> findAllProduct = proDetailRepo.findAll();
		List<ProductCategory> findAllCat = proCatRepo.findAll();
		List<SubProductCategeory> findAllSubCat = subCatRepo.findAll();
		
		map.put("Category", findAllCat);
		map.put("SubCategory", findAllSubCat);
		map.put("Product", findAllProduct);
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}

	@Override
	public List<ProductDetails> getAllProduct(int id) {
		
		List<ProductDetails> findAllSubCatRefId = proDetailRepo.findAllBySubCatRefId(id);
		
		return findAllSubCatRefId;
	}
	

	
		
	

		
		
	
}

package com.shopingcart.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.shopingcart.entity.SubProductCategeory;
import com.shopingcart.repository.SubCategoryProductRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryProductRepository subProRepo;

	@Override
	public ResponseEntity<?> saveSubProduct(SubProductCategeory subProductCategory) {
		Map<String, Object> map = new LinkedHashMap<>();

		SubProductCategeory save = subProRepo.save(subProductCategory);
		map.put("Status", "True");
		map.put("Data", save);

		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllSubCat(int id) {
		Map<String, Object> map = new LinkedHashMap<>();

		List<SubProductCategeory> subCat = subProRepo.findAllByCatRefId(id);

		if (subCat.isEmpty()) {
			;
			map.put("Status", "Fail");
			map.put("message", "Id Not Exists");
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);

		} else {

			map.put("Status", "True");
			map.put("Data", subCat);
			return new ResponseEntity<>(map, HttpStatus.OK);

		}
	}

	@Override
	public SubProductCategeory findBySubCatName(String subCatName) {

		SubProductCategeory findBySubCatName = subProRepo.findBySubCatName(subCatName);

		return findBySubCatName;
	}

	@Override
	public ResponseEntity<?> deleteOneSubCat(int id) {

		Map<String, String> map = new LinkedHashMap<>();
		SubProductCategeory getSubCatById = subProRepo.getBySubCatId(id);

		if (getSubCatById == null) {
			map.put("Status", "Fail");
			map.put("message", "Id not Exists");
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		} else {
			subProRepo.deleteById(id);
			map.put("Status", "True");
			map.put("message", "Record delete Successfully");
			return new ResponseEntity<>(map, HttpStatus.OK);

		}

	}

}

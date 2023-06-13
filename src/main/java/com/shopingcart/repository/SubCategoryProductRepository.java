package com.shopingcart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopingcart.entity.ProductCategory;
import com.shopingcart.entity.SubProductCategeory;

public interface SubCategoryProductRepository extends JpaRepository<SubProductCategeory,Integer> {

	SubProductCategeory getBySubCatId(int catRefId);

	List<SubProductCategeory> findAllByCatRefId(int id);

	 SubProductCategeory findBySubCatName(String subCatName);

	

}

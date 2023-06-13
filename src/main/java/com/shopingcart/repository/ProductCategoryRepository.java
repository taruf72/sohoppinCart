package com.shopingcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopingcart.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

	//boolean existsByCatName(String catName);

	ProductCategory getByCatId(int catRefId);

	ProductCategory findByCatName(String catName);

}

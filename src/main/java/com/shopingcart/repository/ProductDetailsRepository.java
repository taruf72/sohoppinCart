package com.shopingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopingcart.entity.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Integer>{

	ProductDetails getByProDetailsId(int id);

	List<ProductDetails> findAllBySubCatRefId(int id);

	List<ProductDetails> findAllByCatRefId(int id);

	//List<ProductDetails> deleteAllByCatRefId(int id);

	
}

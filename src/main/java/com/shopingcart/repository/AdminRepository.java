package com.shopingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopingcart.entity.UserEntity;

public interface AdminRepository extends JpaRepository<UserEntity,Integer> {

	boolean existsByUsernameAndPassword(String adminName, String password);

	UserEntity getUserByUsername(String username);

	UserEntity findByEmail(String email);

	//void findByUsername(String name);

}

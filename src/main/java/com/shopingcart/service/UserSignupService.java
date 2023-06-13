package com.shopingcart.service;

import org.springframework.http.ResponseEntity;

import com.shopingcart.entity.UserEntity;
import com.shopingcart.entity.UserLogin;

public interface UserSignupService {
	
	public ResponseEntity<?> userSignup(UserEntity admin);

	public UserEntity findByUsername(String name);

	public ResponseEntity<?> userLogin(UserLogin adminlogin) throws Exception;

	public ResponseEntity<?> adminSignup(UserEntity adminSignup);

	public ResponseEntity<?> customerSignup(UserEntity customerSignup);

	public UserEntity findByEmail(String email);

}

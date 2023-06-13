package com.shopingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shopingcart.entity.UserEntity;
import com.shopingcart.entity.UserLogin;
import com.shopingcart.service.UserSignupService;


@RestController
public class UserController {
	@Autowired
	private UserSignupService userServcie;

	
	// THIS API FOR  ADMIN SIGN-UP 
	
	@PostMapping("/adminSignup")
	public ResponseEntity<?> adminSignup(@Valid @RequestBody UserEntity adminSignup){
		
		ResponseEntity<?> adminSignUp = userServcie.adminSignup(adminSignup);
		return adminSignUp;
	}
	
	
	// THIS API FOR CUTOMER SIGN-UP 
	
	@PostMapping("/customerSignup")
	public ResponseEntity<?> customerSignup(@Valid @RequestBody UserEntity customerSignup){
		
		ResponseEntity<?> customerSignUp = userServcie.customerSignup(customerSignup);
		return customerSignUp;
	}
	
	
	
	// THIS API FOR USER LOGIN
	
	@PostMapping("/login")
	public ResponseEntity<?> AdminLogin(@RequestBody UserLogin userlogin) throws Exception{
		
		ResponseEntity<?> adminLogin = userServcie.userLogin(userlogin);
		return adminLogin;
		
	}
	
}

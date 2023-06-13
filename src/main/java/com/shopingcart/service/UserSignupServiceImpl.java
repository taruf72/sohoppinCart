package com.shopingcart.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shopingcart.entity.UserEntity;
import com.shopingcart.entity.UserLogin;
import com.shopingcart.repository.AdminRepository;
import com.shopingcart.util.JwtUtil;
@Service
public class UserSignupServiceImpl implements UserSignupService {
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService userDetailsService; 
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserSignupService userServcie;
	
	@Autowired
	private AdminRepository adminRepo;
	
	

	// THIS METHOD FOR SAVE USER IN DATABASE(USER CAN BE ADMIN OR CUSTOMER)
	@Override
	public ResponseEntity<?> userSignup(UserEntity adminSignup) {
		UserEntity admin = adminRepo.save(adminSignup);
		Map<String,Object> map=new LinkedHashMap<>();
		map.put("status", "true");
		map.put("Admin Details", admin);
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}

	// THIS METHOD FOR LOGIN
	public ResponseEntity<?> userLogin(UserLogin userlogin) throws Exception {

		boolean checkAdminAndPassword = adminRepo.existsByUsernameAndPassword(userlogin.getUsername(),userlogin.getPassword());
		
		if(checkAdminAndPassword==true) {
			Map<String,String> map=new LinkedHashMap<>();
			
				try {
					this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
							userlogin.getUsername(), userlogin.getPassword()));

				} catch (UsernameNotFoundException | BadCredentialsException e) {
					throw new Exception("Bad credentials");
				}
				UserDetails userdetails = this.userDetailsService.loadUserByUsername(userlogin.getUsername());

				final String token = this.jwtUtil.generateToken(userdetails);

				map.put("Status", "true");
				map.put("message", "login successfully");
				map.put("your token is:", token);
				return new ResponseEntity<>(map, HttpStatus.ACCEPTED);

			}
		
		else {
			
			Map<String,String> map=new LinkedHashMap<>();
			map.put("status", "fail");
			map.put("message", "login fail");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		
		
	}

	// THIS METHOD FOR FIND USER BY USERNAME
	@Override
	public UserEntity findByUsername(String name) {
		return adminRepo.getUserByUsername(name);
		
	}

	
	// THIS METHOD FOR  ADMIN SIGNUP
	@Override
	public ResponseEntity<?> adminSignup(UserEntity adminSignup) {

		UserEntity user = userServcie.findByUsername(adminSignup.getUsername());
		UserEntity email= userServcie.findByEmail(adminSignup.getEmail());
		if(user==null && email==null) {
			 adminSignup.setRole("admin");
	
		 ResponseEntity<?> admin = userServcie.userSignup(adminSignup);
		 return admin;}
	
		else {
			
			Map<String,String> map=new LinkedHashMap<>();
			map.put("Status", "fail");
			map.put("message", "This User Already Exists Enter Different Username Or Email");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		
	
	}
	
	 // THIS METHOD FOR CUSTOMER SIGNUP
	@Override
	public ResponseEntity<?> customerSignup(UserEntity customerSignup) {

		UserEntity user = userServcie.findByUsername(customerSignup.getUsername());
		if(user==null) {
			 customerSignup.setRole("customer");
	
		 ResponseEntity<?> admin = userServcie.userSignup(customerSignup);
		 return admin;}
	
		else {
			
			Map<String,String> map=new LinkedHashMap<>();
			map.put("Status", "fail");
			map.put("message", "User Already Exists");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public UserEntity findByEmail(String email) {
		
		adminRepo.findByEmail(email);
		return null;
	}



}

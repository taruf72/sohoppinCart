package com.shopingcart.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.shopingcart.entity.UserEntity;
import com.shopingcart.repository.AdminRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private AdminRepository userRepo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		       UserEntity user = userRepo.getUserByUsername(username); //for fetch user
	     try {		
			if(user==null) {
				 throw new UsernameNotFoundException("user not found exception"+ username); 
			}else {
			return	new User(user.getUsername(),user.getPassword(),new ArrayList<>());
			}}catch(Exception e) {
				e.toString();
			}
	     
	    	 //throw new UsernameNotFoundException("user not found");
	     
	     return null;
	}

}

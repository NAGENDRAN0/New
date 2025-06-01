package com.App.HMS.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.App.HMS.model.UserModel;
import com.App.HMS.model.UserModelPrincipal;
import com.App.HMS.repository.UserModelRepo;

@Service
public class UserModelDetailsServiceImpl implements UserDetailsService{

	
	@Autowired
	private UserModelRepo modelRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    System.out.println("Loading user by username: " + username);  
		UserModel usermd= modelRepo.findByEmail(username);
		if(usermd ==null) {
			throw new UsernameNotFoundException("User not found");
		}
	   // System.out.println("User found: " + usermd.getEmail()); // Debug log
		return new UserModelPrincipal(usermd);
	}

}

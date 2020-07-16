package com.exercise.clientmanagement.security.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exercise.clientmanagement.security.entity.MainUser;
import com.exercise.clientmanagement.security.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userService.getUserByEmail(email);
		return MainUser.build(user);
	}
	
	
	 
}

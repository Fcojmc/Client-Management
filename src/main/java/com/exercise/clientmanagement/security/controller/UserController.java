package com.exercise.clientmanagement.security.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.exercise.clientmanagement.dto.Message;
import com.exercise.clientmanagement.security.dto.JwtDto;
import com.exercise.clientmanagement.security.dto.NewUser;
import com.exercise.clientmanagement.security.dto.UserLogin;
import com.exercise.clientmanagement.security.entity.Role;
import com.exercise.clientmanagement.security.entity.User;
import com.exercise.clientmanagement.security.enums.RoleName;
import com.exercise.clientmanagement.security.jwt.JwtProvider;
import com.exercise.clientmanagement.security.service.RoleService;
import com.exercise.clientmanagement.security.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
    JwtProvider jwtProvider;
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody NewUser newUser){
		
		User findUser = userService.getUserByEmail(newUser.getEmailUser());
		String message = "Email " + newUser.getEmailUser() + " already exists, try another one.";
		
		if(findUser != null) {
			return new ResponseEntity(new Message(message), HttpStatus.BAD_REQUEST);
		}
		
		User user = new User(newUser.getNomUser(), newUser.getPrenomUser(), newUser.getEmailUser(), passwordEncoder.encode(newUser.getPasswordUser()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleService.getByRoleName(RoleName.ROLE_USER));
		
		if(newUser.getRoles().contains("admin")) {
			roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN));
		}
		
		user.setRoles(roles);
		userService.addUser(user);
		
		return new ResponseEntity(new Message("user created"), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@RequestBody UserLogin userLogin){
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPasswordUser()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
}

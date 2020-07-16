package com.exercise.clientmanagement.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MainUser implements UserDetails{
	private String name;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	public MainUser(String name, String lastName, String userName, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.name = name;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static MainUser build(User user) {
		
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
		
		return new MainUser(user.getPrenomUser(), user.getNomUser(), user.getEmailUser(), user.getEmailUser(), user.getPasswordUser(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	
	
}

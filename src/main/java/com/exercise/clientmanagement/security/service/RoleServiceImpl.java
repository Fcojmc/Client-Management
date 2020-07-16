package com.exercise.clientmanagement.security.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.clientmanagement.security.entity.Role;
import com.exercise.clientmanagement.security.enums.RoleName;
import com.exercise.clientmanagement.security.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository repository;
	
	@Override
	public Role getByRoleName(RoleName roleName) {
		// TODO Auto-generated method stub
		return repository.findByRoleName(roleName);
	}

	@Override
	public Role findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}

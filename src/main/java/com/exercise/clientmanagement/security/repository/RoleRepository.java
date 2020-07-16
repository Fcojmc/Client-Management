package com.exercise.clientmanagement.security.repository;


import org.springframework.data.repository.Repository;

import com.exercise.clientmanagement.security.entity.Role;
import com.exercise.clientmanagement.security.enums.RoleName;

public interface RoleRepository extends Repository<Role, Integer>{
	Role findById(Integer id);
	Role findByRoleName(RoleName roleName);	
}

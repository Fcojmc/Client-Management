package com.exercise.clientmanagement.security.service;


import com.exercise.clientmanagement.security.entity.Role;
import com.exercise.clientmanagement.security.enums.RoleName;

public interface RoleService {
	Role findById(Integer id);
	Role getByRoleName(RoleName roleName);
}

package com.exercise.clientmanagement.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.exercise.clientmanagement.security.enums.RoleName;


@Entity
@Table(name = "roles")
public class Role {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "role_name")
	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	public Role(RoleName roleName) {
		this.roleName = roleName;
	}

	public Role() {
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	
	
}

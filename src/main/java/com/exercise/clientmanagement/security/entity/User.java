package com.exercise.clientmanagement.security.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	
	@Column(name = "nom_user")
	private String nomUser;
	
	@Column(name = "prenom_user")
	private String prenomUser;
	
	@Column(name = "email_user")
	private String emailUser;
	
	@Column(name = "password_user")
	private String passwordUser;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
			   joinColumns = @JoinColumn(name="user_id"),
			   inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;

	public User(String nomUser, String prenomUser, String emailUser, String passwordUser) {
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
	}

	public User() {
	}

	public int getId() {
		return idUser;
	}

	public void setId(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
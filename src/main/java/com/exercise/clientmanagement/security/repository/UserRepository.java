package com.exercise.clientmanagement.security.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.exercise.clientmanagement.security.entity.User;

public interface UserRepository extends Repository<User, Integer>{
	List<User> findAll();
	User findById(Integer idUser);
	User findByEmailUser(String emailUser);
	User findByEmailUserAndPasswordUser(String emailUser, String passwordUser);
	void save(User user);
	boolean existsByIdUser(Integer idUser);
	boolean existsByEmailUser(String emailUser);
	void deleteById(Integer idUser);
	
}

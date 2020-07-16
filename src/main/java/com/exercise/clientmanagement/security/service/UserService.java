package com.exercise.clientmanagement.security.service;

import java.util.List;

import com.exercise.clientmanagement.security.entity.User;

public interface UserService {
	List<User> getUsers();
	User getUserById(Integer id);
	User getUserByEmail(String email);
	User getUserByEmailAndPassword(String email, String password);
	void addUser(User user);
	void updateUser(User user);
	boolean existsById(Integer id);
	void deleteUser(Integer id);
}

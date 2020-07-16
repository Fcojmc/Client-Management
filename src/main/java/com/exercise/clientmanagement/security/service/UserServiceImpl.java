package com.exercise.clientmanagement.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.exercise.clientmanagement.security.entity.User;
import com.exercise.clientmanagement.security.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public User getUserById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmailUser(email);
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return repository.findByEmailUserAndPasswordUser(email, password);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	
}

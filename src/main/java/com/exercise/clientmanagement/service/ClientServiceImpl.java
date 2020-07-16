package com.exercise.clientmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.clientmanagement.entity.ClientEntity;
import com.exercise.clientmanagement.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public List<ClientEntity> getClients() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public ClientEntity getOne(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void addClient(ClientEntity client) {
		// TODO Auto-generated method stub
		 repository.save(client);
	}

	@Override
	public void updateClient(ClientEntity client) {
		// TODO Auto-generated method stub
		repository.save(client);
	}

	@Override
	public void deleteClient(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return repository.existsByIdClient(id);
	}
	
}

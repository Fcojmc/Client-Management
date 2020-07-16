package com.exercise.clientmanagement.service;

import java.util.List;

import com.exercise.clientmanagement.entity.ClientEntity;

public interface ClientService {
	List<ClientEntity> getClients();
	ClientEntity getOne(Integer id);
	void addClient(ClientEntity client);
	void updateClient(ClientEntity client);
	boolean existsById(Integer id);
	void deleteClient(Integer id);
}

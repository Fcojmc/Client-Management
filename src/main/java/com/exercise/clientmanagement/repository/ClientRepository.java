package com.exercise.clientmanagement.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.exercise.clientmanagement.entity.ClientEntity;

public interface ClientRepository extends Repository<ClientEntity, Integer>{
	List<ClientEntity> findAll();
	ClientEntity findById(Integer id);
	void save(ClientEntity client);
	boolean existsByIdClient(Integer idClient);
	void deleteById(Integer id);
}

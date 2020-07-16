package com.exercise.clientmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.clientmanagement.dto.ClientDto;
import com.exercise.clientmanagement.dto.Message;
import com.exercise.clientmanagement.entity.ClientEntity;
import com.exercise.clientmanagement.service.ClientService;

@RestController
@RequestMapping("/clients")
@CrossOrigin
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping(path = {"/list"})
	public ResponseEntity<List<ClientEntity>> getUsers(){
		
		List<ClientEntity> list = service.getClients();
		
		return new ResponseEntity<List<ClientEntity>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<ClientEntity> getById(@PathVariable("id") Integer id){
		
		if(!service.existsById(id)) {
			return new ResponseEntity(new Message("does not exist"), HttpStatus.BAD_REQUEST);
		}
		
		ClientEntity client = service.getOne(id);
		return new ResponseEntity<ClientEntity>(client, HttpStatus.OK);
	}
	
	
	@PostMapping(path = {"/create"})
	public ResponseEntity<?> createClient(@RequestBody ClientDto clientDto){
			
		ClientEntity client = new ClientEntity(clientDto.getNomClient(), clientDto.getPrenomClient(), clientDto.getAdresseClient(), 
				clientDto.getCodePostalClient(), clientDto.getVilleClient(), clientDto.getEmailClient(), clientDto.getTelephone1Client());
		
		if(clientDto.getTelephone2Client() != null) {
			client.setTelephone2Client(clientDto.getTelephone2Client());
		}
		
		service.addClient(client);
		return new ResponseEntity(new Message("client created"), HttpStatus.OK);
	}
	
	
	@PutMapping(path = {"/update/{id}"})
	public ResponseEntity<?> updateClient(@PathVariable("id") int id, @RequestBody ClientDto clientDto){
		
		if(!service.existsById(id)) {
			return new ResponseEntity(new Message("client does not exists"), HttpStatus.BAD_REQUEST);
		}
		
		ClientEntity client = new ClientEntity(clientDto.getNomClient(), clientDto.getPrenomClient(), clientDto.getAdresseClient(), 
				clientDto.getCodePostalClient(), clientDto.getVilleClient(), clientDto.getEmailClient(), clientDto.getTelephone1Client());
		
		if(clientDto.getTelephone2Client() != null) {
			client.setTelephone2Client(clientDto.getTelephone2Client());
		}
		
		client.setIdClient(id);
		service.updateClient(client);
		return new ResponseEntity(new Message("client updated"), HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable("id") int id){
		
		if(!service.existsById(id)) {
			return new ResponseEntity(new Message("client does not exists"), HttpStatus.BAD_REQUEST);
		}
		
		service.deleteClient(id);
		return new ResponseEntity(new Message("client deleted"), HttpStatus.OK);
	}
}

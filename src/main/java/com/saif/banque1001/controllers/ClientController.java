package com.saif.banque1001.controllers;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saif.banque1001.dtos.ClientDto;
import com.saif.banque1001.entities.Client;
import com.saif.banque1001.exceptions.BadClientEntityException;
import com.saif.banque1001.services.ClientServiceImplV1;


@RestController
public class ClientController {

	
	private ClientServiceImplV1 clientServiceImplV1;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ClientController(ClientServiceImplV1 clientServiceImplV1) {
		super();
		this.clientServiceImplV1 = clientServiceImplV1;
	}

	
	
	//TODO JUST TO TEST JENKINS
	
	@GetMapping("/clients/{code}")
	public ResponseEntity<ClientDto> findClientByCode(@PathVariable Long code) throws Exception{
		
		//PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
		
		
		Client client = clientServiceImplV1.findClientByCode(code);
		if (client == null)
			return new ResponseEntity<ClientDto>(HttpStatus.NOT_FOUND);
		
		ClientDto clientDto = modelMapper.map(client, ClientDto.class);
		return new ResponseEntity<ClientDto>(clientDto, HttpStatus.OK);
	} 
	
	/*
	 * @PostMapping("/clients") public ResponseEntity<Client>
	 * saveClient(@RequestBody Client client)throws BadClientEntityException { try {
	 * Client savedClient = clientServiceImplV1.saveClient(client); return new
	 * ResponseEntity<>(savedClient, HttpStatus.OK); } catch
	 * (BadClientEntityException e) { //TODO : FAIRE MIEUX CE RETURN :/ throw new
	 * BadClientEntityException("errors", e.getCause()); } }
	 */
	
	
	@PostMapping("/clients")
	public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto)throws BadClientEntityException {
	    try {
	    	
	    	// Map ClientDto to Client entity
	        Client client = modelMapper.map(clientDto, Client.class);
	     // Ajouter le champ "inscription" manuellement
	      //  client.setInscription(new Date());
	        client.setDate_inscription(LocalDateTime.now());
	        
	        Client savedClient = clientServiceImplV1.saveClient(client);
	        return new ResponseEntity<ClientDto>(clientDto, HttpStatus.OK);
	    } catch (BadClientEntityException e) {
	    	//TODO : FAIRE MIEUX CE RETURN :/
	    	 throw new BadClientEntityException("errors", e.getCause());
	    } 
	}

	
}

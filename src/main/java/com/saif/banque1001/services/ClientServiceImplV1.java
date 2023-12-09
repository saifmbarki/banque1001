package com.saif.banque1001.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saif.banque1001.entities.Client;
import com.saif.banque1001.repositories.ClientRepository;

@Service
public class ClientServiceImplV1 implements ClientService {

	
	ClientRepository clientRepository;
	
	//injection dependance par constructeur
	public ClientServiceImplV1(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}


	@Override
	public Client findClientByCode(Long code) {
		
		return clientRepository.findById(code).orElse(null);
		
	}

	@Override
	public Optional<Client> findClientByCin(Long cin) {

		return clientRepository.findClientByCin(cin);
	}


	@Override
	public List<Client> findClientsByNomEtPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return clientRepository.findClientsByNomAndPrenom(nom, prenom);
	}


	//ajout ou mise a jour
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}




}

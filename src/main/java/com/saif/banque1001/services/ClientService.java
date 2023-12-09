package com.saif.banque1001.services;

import java.util.List;
import java.util.Optional;

import com.saif.banque1001.entities.Client;

public interface ClientService {

	
	public Client findClientByCode(Long code);
	
	public Optional<Client> findClientByCin(Long cin);
	
	//recherche LIKE
	public List<Client> findClientsByNomEtPrenom(String nom,String prenom);
	
	
	//ajout ou modification (sauf le solde) d'un client
	public Client saveClient(Client client);
	
	
	
}

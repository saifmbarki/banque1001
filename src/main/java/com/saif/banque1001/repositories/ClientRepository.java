package com.saif.banque1001.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saif.banque1001.entities.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	
	public Optional<Client> findClientByCin(Long cin);
	
	
	public List<Client> findClientsByNomAndPrenom(String nom, String prenom);
	
	
}

package com.saif.banque1001;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saif.banque1001.entities.Client;
import com.saif.banque1001.enums.Agence;
import com.saif.banque1001.enums.SituationClient;
import com.saif.banque1001.repositories.ClientRepository;
import com.saif.banque1001.services.ClientServiceImplV1;

@SpringBootApplication
public class Banque1001Application implements CommandLineRunner{

	@Autowired
	ClientRepository clientRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Banque1001Application.class, args);
	}


	
	
	


	@Override
	public void run(String... args) throws Exception {
		ClientServiceImplV1 clientServiceImplV1 = new ClientServiceImplV1(clientRepository);
		
	for (int i = 0; i < 10; i++) {
		
        Client client = new Client((long) 14241853, "saif 100"+i, "mbarki", "souk jedid", "cse", Agence.SidiBouzid, SituationClient.actif, null, null, null);
		 
		 
		 clientServiceImplV1.saveClient(client);
	}
		
		
		 
		
	}





}

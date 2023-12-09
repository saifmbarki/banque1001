package com.saif.banque1001.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.saif.banque1001.entities.Client;
import com.saif.banque1001.enums.Agence;
import com.saif.banque1001.enums.SituationClient;
import com.saif.banque1001.services.ClientServiceImplV1;
@SpringBootTest
public class ClientServiceTest {

	//injection depenadance par annotation
	//n'est pas bon pratique mais puisque nous somme dans class test: en s'on fou
	@Autowired
	ClientServiceImplV1 clientService;
	
	@Test
	public void findClientByCode_mustReturnClient() {
	    // Création d'un client
	    Client client = new Client((long) 1, (long) 14241853, "saif", "mbarki", "souk jedid", "cse", Agence.SidiBouzid, SituationClient.actif, null, null, null);

	    // Sauvegarde du client
	    Client x = clientService.saveClient(client);
	    assertThat(x).isNotNull();

	    // Recherche du client par code
	    Long clientCode = (long) 1;
	    Client z = clientService.findClientByCode(clientCode).orElse(null);
	    
	   assertThat(z).isNotNull();
	   assertThat(z.getCode()).isEqualTo(clientCode);
	}
	
}

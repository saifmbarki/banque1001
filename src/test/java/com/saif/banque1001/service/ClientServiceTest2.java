package com.saif.banque1001.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.saif.banque1001.entities.Client;
import com.saif.banque1001.enums.Agence;
import com.saif.banque1001.enums.SituationClient;
import com.saif.banque1001.repositories.ClientRepository;
import com.saif.banque1001.services.ClientService;
import com.saif.banque1001.services.ClientServiceImplV1;
@SpringBootTest
public class ClientServiceTest2 {

	 @Mock
	    private ClientRepository clientRepository;

	    @InjectMocks
	    private ClientServiceImplV1 clientService;

	    @SuppressWarnings("deprecation")
		@Before(value = "")
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testFindClientByCode() {
	        // Given
	        Long code = 1L;
	        Client expectedClient = new Client();
	        when(clientRepository.findById(code)).thenReturn(Optional.of(expectedClient));

	        // When
	        Optional<Client> result = clientService.findClientByCode(code);

	        // Then
	        //assertThat(expectedClient, result.orElse(null));
	        verify(clientRepository, times(1)).findById(code);
	    }

	    
	    
	    
	    /*
	     * 
	     * 
	     * 
	     * */
	    
	    
	    
		/*
		 * @Mock private ClientRepository clientRepository;
		 * 
		 * @InjectMocks private ClientServiceImplV1 clientService;
		 * 
		 * @Before public void setup() { MockitoAnnotations.initMocks(this); }
		 * 
		 * @Test public void testFindClientByCode() { // Given Long code = 1L; Client
		 * expectedClient = new Client();
		 * when(clientRepository.findById(code)).thenReturn(Optional.of(expectedClient))
		 * ;
		 * 
		 * // When Optional<Client> result = clientService.findClientByCode(code);
		 * 
		 * // Then assertEquals(expectedClient, result.orElse(null));
		 * verify(clientRepository, times(1)).findById(code); }
		 * 
		 * @Test public void testFindClientByCin() { // Given Long cin = 123456L; Client
		 * expectedClient = new Client();
		 * when(clientRepository.findClientByCin(cin)).thenReturn(Optional.of(
		 * expectedClient));
		 * 
		 * // When Optional<Client> result = clientService.findClientByCin(cin);
		 * 
		 * // Then assertEquals(expectedClient, result.orElse(null));
		 * verify(clientRepository, times(1)).findClientByCin(cin); }
		 * 
		 * @Test public void testFindClientsByNomEtPrenom() { // Given String nom =
		 * "Doe"; String prenom = "John"; List<Client> expectedClients = new
		 * ArrayList<>(); when(clientRepository.findClientsByNomAndPrenom(nom,
		 * prenom)).thenReturn(expectedClients);
		 * 
		 * // When List<Client> result = clientService.findClientsByNomEtPrenom(nom,
		 * prenom);
		 * 
		 * // Then assertEquals(expectedClients, result); verify(clientRepository,
		 * times(1)).findClientsByNomAndPrenom(nom, prenom); }
		 * 
		 * @Test public void testSaveClient() { // Given Client clientToSave = new
		 * Client(); when(clientRepository.save(clientToSave)).thenReturn(clientToSave);
		 * 
		 * // When Client result = clientService.saveClient(clientToSave);
		 * 
		 * // Then assertEquals(clientToSave, result); verify(clientRepository,
		 * times(1)).save(clientToSave); }
		 */
	    
	  
}

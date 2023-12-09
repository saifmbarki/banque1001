package com.saif.banque1001.dtos;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.saif.banque1001.entities.Compte;
import com.saif.banque1001.enums.Agence;
import com.saif.banque1001.enums.SituationClient;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {

	
	private Long cin;
	private String nom;
	private String prenom;
	private String adresse;
	private String metier;
	private Agence agence;
	private SituationClient situationClient;
	
	@Temporal(TemporalType.DATE)
	private Date date_naissance;
	
	/*
	 * @Temporal(TemporalType.TIMESTAMP) private LocalDateTime date_inscription;
	 * 
	 * @OneToMany(mappedBy = "client", cascade = CascadeType.ALL) private
	 * List<Compte> comptes;
	 */
	
	
	
	
}

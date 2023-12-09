package com.saif.banque1001.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.saif.banque1001.enums.Agence;
import com.saif.banque1001.enums.SituationClient;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Client implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private Long cin;
	private String nom;
	private String prenom;
	private String adresse;
	private String metier;
	private Agence agence;
	private SituationClient situationClient;
	
	@Temporal(TemporalType.DATE)
	private Date date_naissance;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime date_inscription;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Compte> comptes;

	public Client(Long cin, String nom, String prenom, String adresse, String metier, Agence agence,
			SituationClient situationClient, Date date_naissance, LocalDateTime date_inscription,
			List<Compte> comptes) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.metier = metier;
		this.agence = agence;
		this.situationClient = situationClient;
		this.date_naissance = date_naissance;
		this.date_inscription = date_inscription;
		this.comptes = comptes;
	}

	
	
	

}

package com.saif.banque1001.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.saif.banque1001.enums.SituationCompte;
import com.saif.banque1001.enums.TypeCompte;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Compte implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	
	private TypeCompte typeCompte;

	private SituationCompte situationCompte;
	
	private Double solde;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime date_creation;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime date_fermeture;
	
    @ManyToOne
    @JoinColumn(name = "client_code")
    private Client client;
	

	
	
}

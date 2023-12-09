package com.saif.banque1001.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saif.banque1001.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long>{

}

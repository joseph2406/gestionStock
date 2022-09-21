package tn.gestionstock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}

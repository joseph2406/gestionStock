package tn.gestionstock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}

package tn.gestionstock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.LigneCommandeClient;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {

}

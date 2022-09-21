package tn.gestionstock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.LigneVente;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {

}

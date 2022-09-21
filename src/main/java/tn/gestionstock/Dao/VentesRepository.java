package tn.gestionstock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.Ventes;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

}

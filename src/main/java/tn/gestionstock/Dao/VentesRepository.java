package tn.gestionstock.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.Ventes;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {
	Optional<Ventes> findByCode(String code);
}

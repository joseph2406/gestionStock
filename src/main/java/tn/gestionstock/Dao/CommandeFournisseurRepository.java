package tn.gestionstock.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.CommandeFournisseur;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {
	Optional<CommandeFournisseur> findByCode(String code);
}

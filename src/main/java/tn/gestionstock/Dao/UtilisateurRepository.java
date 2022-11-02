package tn.gestionstock.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	Optional<Utilisateur> findByEmail(String email);
}

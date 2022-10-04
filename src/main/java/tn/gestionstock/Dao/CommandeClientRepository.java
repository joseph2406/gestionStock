package tn.gestionstock.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {
	Optional<CommandeClient> findByCode(String code);
}

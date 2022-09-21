package tn.gestionstock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

}

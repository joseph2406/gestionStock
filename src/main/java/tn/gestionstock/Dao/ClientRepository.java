package tn.gestionstock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}

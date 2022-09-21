package tn.gestionstock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.MvtStk;

public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {

}

package tn.gestionstock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

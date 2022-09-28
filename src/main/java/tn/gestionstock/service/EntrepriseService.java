package tn.gestionstock.service;

import java.util.List;

import tn.gestionstock.Dto.EntrepriseDto;

public interface EntrepriseService {
	EntrepriseDto save(EntrepriseDto entreprise);
	EntrepriseDto findById(Integer id);
	List<EntrepriseDto> findAll();
	void delete(Integer id);
}

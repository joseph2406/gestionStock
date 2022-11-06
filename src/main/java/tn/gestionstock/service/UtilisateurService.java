package tn.gestionstock.service;

import java.util.List;

import tn.gestionstock.Dto.UtilisateurDto;

public interface UtilisateurService {
	UtilisateurDto save(UtilisateurDto utilisateur);
	UtilisateurDto findById(Integer id);
	List<UtilisateurDto> findAll();
	void delete(Integer id);
	UtilisateurDto findByEmail(String mail);
	

}

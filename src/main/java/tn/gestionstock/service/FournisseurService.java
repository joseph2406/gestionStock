package tn.gestionstock.service;

import java.util.List;

import tn.gestionstock.Dto.FournisseurDto;

public interface FournisseurService {
	FournisseurDto save(FournisseurDto fournisseurDto);
	FournisseurDto findById(Integer id);
	List<FournisseurDto> findAll();
	void delete(Integer id);

}

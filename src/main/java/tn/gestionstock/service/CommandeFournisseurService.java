package tn.gestionstock.service;

import java.util.List;

import tn.gestionstock.Dto.CommandeFournisseurDto;

public interface CommandeFournisseurService {
	CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);
	CommandeFournisseurDto findById(Integer id);
	CommandeFournisseurDto findByCode(String code);
	List<CommandeFournisseurDto> findAll();
	void delete(Integer id);
}

package tn.gestionstock.service;

import java.util.List;

import tn.gestionstock.Dto.CommandeClientDto;

public interface CommandeClientService {
	CommandeClientDto save(CommandeClientDto commandeClientDto);
	CommandeClientDto findById(Integer id);
	CommandeClientDto findByCode(String code);
	List<CommandeClientDto> findAll();
	void delete(Integer id);

}

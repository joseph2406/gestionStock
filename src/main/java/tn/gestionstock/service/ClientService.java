package tn.gestionstock.service;

import java.util.List;

import tn.gestionstock.Dto.ClientDto;

public interface ClientService {
	ClientDto save(ClientDto clientDto);
	ClientDto findById(Integer id);
	List<ClientDto> findAll();
	void delete(Integer id);
}

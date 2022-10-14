package tn.gestionstock.service;

import java.util.List;

import tn.gestionstock.Dto.VentesDto;

public interface VentesService {
	VentesDto save(VentesDto ventesDto);
	VentesDto findById(Integer id);
	VentesDto findByCode(String code);
	List<VentesDto> findAll();
	void delete(Integer id);
}

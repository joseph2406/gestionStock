package tn.gestionstock.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dto.VentesDto;
import tn.gestionstock.service.VentesService;
@RestController
@Transactional
@Slf4j
public class VentesController implements VentesApi {
	private final VentesService ventesSer;
	
	public VentesController(VentesService ventesSer) {
		super();
		this.ventesSer = ventesSer;
	}

	@Override
	public VentesDto save(VentesDto ventesDto) {
		
		return ventesSer.save(ventesDto);
	}

	@Override
	public VentesDto findById(Integer id) {
		
		return ventesSer.findById(id);
	}

	@Override
	public VentesDto findByCode(String code) {
		
		return ventesSer.findByCode(code);
	}

	@Override
	public List<VentesDto> findAll() {
		
		return ventesSer.findAll();
	}

	@Override
	public void delete(Integer id) {
		ventesSer.delete(id);

	}

}

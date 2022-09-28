package tn.gestionstock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import tn.gestionstock.Dto.EntrepriseDto;
import tn.gestionstock.service.EntrepriseService;
@RestController
public class EntrepriseController implements EntrepriseApi{
	private final EntrepriseService entSer;
	
	public EntrepriseController(EntrepriseService entSer) {
		super();
		this.entSer = entSer;
	}

	@Override
	public EntrepriseDto save(EntrepriseDto entreprise) {
		
		return entSer.save(entreprise);
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		
		return entSer.findById(id);
	}

	@Override
	public List<EntrepriseDto> findAll() {
		
		return entSer.findAll();
	}

	@Override
	public void delete(Integer id) {
		entSer.delete(id);
		
	}

}

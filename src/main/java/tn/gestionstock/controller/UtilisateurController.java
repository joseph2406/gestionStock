package tn.gestionstock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import tn.gestionstock.Dto.UtilisateurDto;
import tn.gestionstock.service.UtilisateurService;
@RestController
public class UtilisateurController implements UtilisateurApi{
	private final UtilisateurService utilSer;
	
	public UtilisateurController(UtilisateurService utilSer) {
		super();
		this.utilSer = utilSer;
	}

	@Override
	public UtilisateurDto save(UtilisateurDto utilisateur) {
		
		return utilSer.save(utilisateur);
	}

	@Override
	public UtilisateurDto findById(Integer id) {
		
		return utilSer.findById(id);
	}

	@Override
	public List<UtilisateurDto> findAll() {
		
		return utilSer.findAll();
	}

	@Override
	public void delete(Integer id) {
		utilSer.delete(id);
		
	}

}

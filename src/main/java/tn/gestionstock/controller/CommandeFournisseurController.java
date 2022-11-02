package tn.gestionstock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import tn.gestionstock.Dto.CommandeFournisseurDto;
import tn.gestionstock.service.CommandeFournisseurService;
@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {
	private final CommandeFournisseurService commandeFournisseurService;
	
	public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
		super();
		this.commandeFournisseurService = commandeFournisseurService;
	}

	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
		
		return commandeFournisseurService.save(commandeFournisseurDto);
	}

	@Override
	public CommandeFournisseurDto findById(Integer id) {
		
		return commandeFournisseurService.findById(id);
	}

	@Override
	public CommandeFournisseurDto findByCode(String code) {
		
		return commandeFournisseurService.findByCode(code);
	}

	@Override
	public List<CommandeFournisseurDto> findAll() {
		
		return commandeFournisseurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		commandeFournisseurService.delete(id);

	}

}

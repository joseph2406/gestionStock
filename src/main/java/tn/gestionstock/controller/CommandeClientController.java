package tn.gestionstock.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import tn.gestionstock.Dto.CommandeClientDto;
import tn.gestionstock.service.CommandeClientService;
@RestController
public class CommandeClientController implements CommandeClientApi {
	private final CommandeClientService commandeclientService;
	
	public CommandeClientController(CommandeClientService commandeclientService) {
		super();
		this.commandeclientService = commandeclientService;
	}

	@Override
	public ResponseEntity<CommandeClientDto> save(CommandeClientDto commandeClientDto) {
		
		return ResponseEntity.ok(commandeclientService.save(commandeClientDto));
	}

	@Override
	public ResponseEntity<CommandeClientDto> findById(Integer id) {
		
		return ResponseEntity.ok(commandeclientService.findById(id));
	}

	@Override
	public ResponseEntity<CommandeClientDto> findByCode(String code) {
		
		return ResponseEntity.ok(commandeclientService.findByCode(code));
	}

	@Override
	public ResponseEntity<List<CommandeClientDto>> findAll() {
		
		return ResponseEntity.ok(commandeclientService.findAll());
	}

	@Override
	public ResponseEntity delete(Integer id) {
		commandeclientService.delete(id);
		return ResponseEntity.ok().build();
	}

}

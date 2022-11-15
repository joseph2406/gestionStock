package tn.gestionstock.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import tn.gestionstock.Dto.CommandeClientDto;
import tn.gestionstock.entities.EtatCommande;
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

	@Override
	public ResponseEntity<CommandeClientDto> updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
		
		 return ResponseEntity.ok(commandeclientService.updateEtatCommande(idCommande, etatCommande));
	}

	@Override
	public ResponseEntity<CommandeClientDto> updateQuantiteCommande(Integer idCommande, Integer idLigneCommande,
			BigDecimal qte) {
		return ResponseEntity.ok(commandeclientService.updateQuantiteCommande(idCommande, idCommande, qte));
	}

	@Override
	public ResponseEntity<CommandeClientDto> updateClientCommande(Integer idCommande, Integer idClient) {
		
		return ResponseEntity.ok(commandeclientService.updateClientCommande(idCommande, idClient));
	}

	@Override
	public ResponseEntity<CommandeClientDto> updateArticleCommande(Integer idCommande, Integer idLigneCommande,
			Integer newArticle) {
		
		return ResponseEntity.ok(commandeclientService.updateArticleCommande(idCommande, idLigneCommande, newArticle));
	}

}

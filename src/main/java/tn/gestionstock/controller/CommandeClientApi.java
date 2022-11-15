package tn.gestionstock.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.gestionstock.Dto.CommandeClientDto;
import tn.gestionstock.entities.EtatCommande;

import static tn.gestionstock.utils.Constant.APP_ROOT;
@Api(APP_ROOT+"commandesClients")
public interface CommandeClientApi {
	@PostMapping(APP_ROOT+"commandesClients/create")
	ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto commandeClientDto);
	@PatchMapping(APP_ROOT+"commandesClients/update/{idCommande}/{etatCommande}")
	ResponseEntity<CommandeClientDto> updateEtatCommande(@PathVariable Integer idCommande,
			@PathVariable EtatCommande etatCommande);
	@GetMapping(APP_ROOT+"commandesClients/findById/{id}")
	ResponseEntity<CommandeClientDto> findById(@PathVariable Integer id);
	@GetMapping(APP_ROOT+"commandesClients/findBycode/{code}")
	ResponseEntity<CommandeClientDto> findByCode(@PathVariable String code);
	@GetMapping(APP_ROOT+"commandesClients/all")
	ResponseEntity<List<CommandeClientDto>> findAll();
	@DeleteMapping(APP_ROOT+"commandesClients/delete/{id}")
	ResponseEntity delete(@PathVariable Integer id);
	@PatchMapping(APP_ROOT+"commandesClients/update/{idCommande}/{idLigneCommand}/{qte}")
	ResponseEntity<CommandeClientDto> updateQuantiteCommande(@PathVariable Integer idCommande, @PathVariable Integer idLigneCommande, @PathVariable BigDecimal qte);
	@PatchMapping(APP_ROOT+"commandesClients/updateClient/{idCommande}/{idClient}")
	ResponseEntity<CommandeClientDto> updateClientCommande(@PathVariable Integer idCommande, @PathVariable Integer idClient);
	@PatchMapping(APP_ROOT+"commandesClients/updateArticle/{idCommande}/{idLigneCommande}/{newArticle}")
	ResponseEntity<CommandeClientDto> updateArticleCommande(@PathVariable Integer idCommande,@PathVariable Integer idLigneCommande,@PathVariable Integer newArticle);
}

package tn.gestionstock.service;

import java.math.BigDecimal;
import java.util.List;

import tn.gestionstock.Dto.CommandeClientDto;
import tn.gestionstock.entities.EtatCommande;

public interface CommandeClientService {
	CommandeClientDto save(CommandeClientDto commandeClientDto);
	CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);
	CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer IdLigneCommande,BigDecimal qte);
	CommandeClientDto updateClientCommande(Integer idCommande, Integer idClient);
	CommandeClientDto updateArticleCommande(Integer idCommande, Integer idLigneCommande,Integer newArticle);
	CommandeClientDto findById(Integer id);
	CommandeClientDto findByCode(String code);
	List<CommandeClientDto> findAll();
	void delete(Integer id);

}

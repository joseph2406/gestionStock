package tn.gestionstock.Dto;

import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import tn.gestionstock.entities.EtatCommande;
@Data
@Builder
public class CommandeClientDto {
	private Integer id;
	private String code;
	private Instant dateCommande;
	private ClientDto client;
	private EtatCommande etatCommande;
	private List<LigneCommandeClientDto> ligneCommandeClients;
	public  boolean isCommandeLivree() {
		return EtatCommande.LIVREE.equals(this.etatCommande);
		
	}
}

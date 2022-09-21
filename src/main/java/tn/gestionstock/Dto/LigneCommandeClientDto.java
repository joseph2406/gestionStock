package tn.gestionstock.Dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class LigneCommandeClientDto {
	private Integer id;
	private ArticleDto article;
	private CommandeClientDto commandeClient;
	private BigDecimal quantité;
	private BigDecimal prixUnitaire;
	
}

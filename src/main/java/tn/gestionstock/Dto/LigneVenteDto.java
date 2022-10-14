package tn.gestionstock.Dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;
import tn.gestionstock.entities.Article;

@Data
@Builder
public class LigneVenteDto {
	private Integer id;
	private VentesDto vente;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	private ArticleDto articleDto;

}

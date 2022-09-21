package tn.gestionstock.Dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {
	private Integer id;
	private ArticleDto article;
	private CommandeFournisseurDto commandeFournisseurs;
	private BigDecimal quantité;
	private BigDecimal prixUnitaire;
}

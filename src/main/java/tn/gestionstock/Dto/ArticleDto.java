package tn.gestionstock.Dto;

import java.math.BigDecimal;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ArticleDto {
	private Integer id;
	private String codeArticle;
	private String designation;
	private BigDecimal prixUnitaireHt;
	private BigDecimal tauxTva;
	private BigDecimal prixUnitaireTtc;
	private String photo;
	private Integer IdEntreprise;
	//private CategoryDto category;
}

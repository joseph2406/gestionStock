package tn.gestionstock.Dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.Builder;
import lombok.Data;
import tn.gestionstock.entities.TypeMvStk;

@Data
@Builder
public class MvtStkDto {
	private Integer id;
	private Instant dateMvt;
	private BigDecimal quantite;
	private ArticleDto article;
	private TypeMvStk typeMvtStk;
}

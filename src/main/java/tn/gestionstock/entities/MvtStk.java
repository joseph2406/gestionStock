package tn.gestionstock.entities;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name="mvtstk")
public class MvtStk  extends AbsrtactEntity{
	private Instant dateMvt;
	private BigDecimal quantite;
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;
	private TypeMvStk typeMvtStk;
}

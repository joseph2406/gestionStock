package tn.gestionstock.entities;

import java.math.BigDecimal;

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
@Table(name="lignevente")
public class LigneVente  extends AbsrtactEntity{
	@ManyToOne
	@JoinColumn(name="idvente")
	private Ventes vente;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	private Article article;
}

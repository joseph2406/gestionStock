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
@Table(name="lignecommandeclient")
public class LigneCommandeClient  extends AbsrtactEntity{
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;
	@ManyToOne
	@JoinColumn(name="idcommandeclient")
	private CommandeClient commandeClient;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
}

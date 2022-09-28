package tn.gestionstock.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="lignecommandefournisseur")
public class LigneCommandeFournisseur  extends AbsrtactEntity{
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;
	@ManyToOne
	@JoinColumn(name="idcommandefournisseur")
	private CommandeFournisseur commandeFournisseurs;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
}

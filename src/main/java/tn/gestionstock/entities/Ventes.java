package tn.gestionstock.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name="ventes")
public class Ventes  extends AbsrtactEntity{
	private String code;
	private Instant dateVente;
	private String commentaire;
	@OneToMany(mappedBy ="vente")
	private List<LigneVente> ligneVentes;
}

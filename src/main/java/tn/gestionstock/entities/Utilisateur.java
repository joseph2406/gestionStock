package tn.gestionstock.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.Embedded;
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
@Table(name="utilisateur")
public class Utilisateur  extends AbsrtactEntity{
	private String nom;
	private String prenom;
	private String email;
	private Instant dateNaissance;
	private String password;
	@Embedded
	private Adresse adresse;
	private String photo;
	@ManyToOne
	@JoinColumn(name="identreprise")
	private Entreprise entreprise;
	@OneToMany(mappedBy = "utilisateur")
	private List<Roles> roles;
	
}

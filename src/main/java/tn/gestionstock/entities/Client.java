package tn.gestionstock.entities;

import java.util.List;

import javax.persistence.Embedded;
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
@Table(name="client")
public class Client  extends AbsrtactEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	@Embedded
	private Adresse adresse;
	private String photo;
	private String mail;
	private String numTel;
	@OneToMany(mappedBy = "client")
	private List<CommandeClient> commandeClients;
}

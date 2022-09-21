package tn.gestionstock.Dto;

import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UtilisateurDto {
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private Instant dateNaissance;
	private String password;
	private AdresseDto adresse;
	private String photo;
	private EntrepriseDto entreprise;
	private List<RolesDto> roles;
}

package tn.gestionstock.Dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import tn.gestionstock.entities.Adresse;
@Data
@Builder
public class ClientDto {
	private Integer id;
	private String nom;
	private String prenom;
	private Adresse adresse;
	private String photo;
	private String mail;
	private String numTel;
	private List<CommandeClientDto> commandeClients;
}

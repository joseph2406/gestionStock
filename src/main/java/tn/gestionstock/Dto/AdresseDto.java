package tn.gestionstock.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDto {
	private String adresse1;
	private String adresse2;
	private String Ville;
	private String CodePostale;
	private String pays;
}

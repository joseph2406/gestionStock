package tn.gestionstock.Dto;

import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class VentesDto {
	private Integer id;
	private String code;
	private Instant dateVente;
	private String commentaire;
	private List<LigneVenteDto> ligneVentesDto;
}

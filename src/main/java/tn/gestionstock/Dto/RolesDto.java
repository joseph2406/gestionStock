package tn.gestionstock.Dto;

import lombok.Builder;
import lombok.Data;
import tn.gestionstock.entities.AbsrtactEntity;
import tn.gestionstock.entities.Utilisateur;
@Data
@Builder
public class RolesDto extends AbsrtactEntity{
	private Integer id;
	private String roleName;
	private Utilisateur utilisateur;

}

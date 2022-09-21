package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.UtilisateurDto;
import tn.gestionstock.entities.Utilisateur;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UtilisateurMapper extends GenericMapper<UtilisateurDto, Utilisateur> {

}

package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.EntrepriseDto;
import tn.gestionstock.entities.Entreprise;
@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EntrepriseMapper extends GenericMapper<EntrepriseDto, Entreprise> {

}

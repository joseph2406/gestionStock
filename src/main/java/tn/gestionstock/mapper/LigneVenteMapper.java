package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.LigneVenteDto;
import tn.gestionstock.entities.LigneVente;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LigneVenteMapper extends GenericMapper<LigneVenteDto, LigneVente> {

}

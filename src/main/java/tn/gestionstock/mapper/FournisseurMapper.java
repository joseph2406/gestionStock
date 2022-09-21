package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.FournisseurDto;
import tn.gestionstock.entities.Fournisseur;
@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FournisseurMapper extends GenericMapper<FournisseurDto, Fournisseur> {

}

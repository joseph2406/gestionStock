package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.LigneCommandeFournisseurDto;
import tn.gestionstock.entities.LigneCommandeFournisseur;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LigneCommandeFournisseurMapper extends GenericMapper<LigneCommandeFournisseurDto,LigneCommandeFournisseur> {

}

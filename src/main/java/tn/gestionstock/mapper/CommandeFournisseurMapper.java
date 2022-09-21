package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.CommandeFournisseurDto;
import tn.gestionstock.entities.CommandeFournisseur;
@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CommandeFournisseurMapper extends GenericMapper<CommandeFournisseurDto, CommandeFournisseur> {

}

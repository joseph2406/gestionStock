package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.VentesDto;
import tn.gestionstock.entities.Ventes;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VentesMapper extends GenericMapper<VentesDto, Ventes> {

}

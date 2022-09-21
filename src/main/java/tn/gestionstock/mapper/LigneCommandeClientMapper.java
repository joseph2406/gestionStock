package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.LigneCommandeClientDto;
import tn.gestionstock.entities.LigneCommandeClient;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LigneCommandeClientMapper extends GenericMapper<LigneCommandeClientDto, LigneCommandeClient> {

}

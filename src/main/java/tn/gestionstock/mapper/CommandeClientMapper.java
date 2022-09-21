package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.CommandeClientDto;
import tn.gestionstock.entities.CommandeClient;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CommandeClientMapper extends GenericMapper<CommandeClientDto, CommandeClient> {

}

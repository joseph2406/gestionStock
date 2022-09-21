package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.RolesDto;
import tn.gestionstock.entities.Roles;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RolesMapper extends GenericMapper<RolesDto, Roles> {

}

package tn.gestionstock.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.MvtStkDto;
import tn.gestionstock.entities.MvtStk;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MvtStkMapper extends GenericMapper<MvtStkDto, MvtStk> {

}

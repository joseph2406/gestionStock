package tn.gestionstock.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import tn.gestionstock.Dto.ArticleDto;
import tn.gestionstock.entities.Article;
@Component
@Mapper(componentModel = "spring")
public interface ArticleMapper extends GenericMapper<ArticleDto, Article> {

}

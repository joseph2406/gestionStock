package tn.gestionstock.service;

import java.util.List;


import tn.gestionstock.Dto.ArticleDto;

public interface ArticleService {
	ArticleDto save(ArticleDto article);
	ArticleDto findById(Integer id);
	ArticleDto findByCodeArticle(String code);
	List<ArticleDto> findAll();
	void delete(Integer id);

}

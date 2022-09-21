package tn.gestionstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tn.gestionstock.Dto.ArticleDto;
import tn.gestionstock.service.ArticleService;
@RestController
public class ArticleController implements ArticleApi {
	@Autowired
	private ArticleService articleService;

	/*
	 * public ArticleController(ArticleService articleService) {
	 * 
	 * this.articleService = articleService; }
	 */
	@Override
	public ArticleDto save(ArticleDto article) {
		return articleService.save(article);
	}

	@Override
	public ArticleDto findById(Integer id) {
		
		return articleService.findById(id);
	}

	@Override
	public ArticleDto findByCodeArticle(String code) {
		return articleService.findByCodeArticle(code);
	}

	@Override
	public List<ArticleDto> findAll() {
		return articleService.findAll();
	}

	@Override
	public void delete(Integer id) {
		articleService.delete(id);
	}

}

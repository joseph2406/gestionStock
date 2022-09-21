package tn.gestionstock.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.gestionstock.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	Optional<Article> findArticleBycodeArticle(String codeArticle);
}

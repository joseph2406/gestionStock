package tn.gestionstock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dao.ArticleRepository;
import tn.gestionstock.Dto.ArticleDto;
import tn.gestionstock.entities.Article;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ListIsEmptyOrNullException;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
import tn.gestionstock.exception.MapProblem;
import tn.gestionstock.mapper.ArticleMapper;
@Service
@Slf4j
@Transactional
public class ArticleServiceImpl implements ArticleService{
	private final ArticleRepository repoArt;
	private final ArticleMapper mapArt;
	
	public ArticleServiceImpl(ArticleRepository repoArt, ArticleMapper mapArt) {
		super();
		this.repoArt = repoArt;
		this.mapArt = mapArt;
	}

	@Override
	public ArticleDto save(ArticleDto article) {
		try {
		Article art=mapArt.fromDtoToEntity(article);
		repoArt.save(art);
		log.error("Article saved {}",art.getId());
		}
		catch (Exception e) {
			log.error("Article is not valid");
			throw new InvalidEntityException("Article non valide", ErrorCodes.ARTICLE_NOT_VALID);
		}
		return article;
	}

	@Override
	public ArticleDto findById(Integer id) {
		if(id==null) {
			log.error("id is null {}",id);
			return null;
		}
		Optional<Article> art=repoArt.findById(id);
		if(art.isPresent()) {
		return Optional.of(mapArt.fromEntityToDto(art.get())).orElseThrow(()->new MapProblem("Mappage impossible l'ip="+id+"",ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
		throw new EntityNotFoundException("Article non trouvé avec l'id={}"+id,ErrorCodes.ARTICLE_NOT_FOUND);
	}

	@Override
	public ArticleDto findByCodeArticle(String code) {
		if(StringUtils.hasLength(code)) {
			log.error("code article est null");
		}
		Optional<Article> art=repoArt.findArticleBycodeArticle(code);
		ArticleDto dto=mapArt.fromEntityToDto(art.get());
		
		return Optional.of(dto).orElseThrow(()->new EntityNotFoundException
				("Article non trouvé pour le code"+code,ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<ArticleDto> findAll() {
		List<Article> listArt=repoArt.findAll();
		if(ObjectUtils.isEmpty(listArt)) {
			throw new ListIsEmptyOrNullException("Liste Vide ou Null",ErrorCodes.LIST_EMPTY_OR_NULL);
		}
		return mapArt.fromEntitiesToDtoList(listArt);
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			log.error("Article id is null");
			return;
		}
	repoArt.deleteById(id);
		
	}

}

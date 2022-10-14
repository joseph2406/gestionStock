package tn.gestionstock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dao.ArticleRepository;
import tn.gestionstock.Dao.LigneVenteRepository;
import tn.gestionstock.Dao.VentesRepository;
import tn.gestionstock.Dto.VentesDto;
import tn.gestionstock.entities.Article;
import tn.gestionstock.entities.LigneVente;
import tn.gestionstock.entities.Ventes;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
import tn.gestionstock.exception.ListIsEmptyOrNullException;
import tn.gestionstock.exception.MapProblem;
import tn.gestionstock.mapper.LigneVenteMapper;
import tn.gestionstock.mapper.VentesMapper;
@Service
@Slf4j
public class VentesServiceImpl implements VentesService {
	private final ArticleRepository artRepo;
	private final VentesRepository venteRepo;
	private final LigneVenteRepository ligVenteRepo;
	private final VentesMapper venteMap;
	private final LigneVenteMapper LigventeMap;

	public VentesServiceImpl(ArticleRepository artRepo, VentesRepository venteRepo, LigneVenteRepository ligVenteRepo,
			VentesMapper venteMap, LigneVenteMapper ligventeMap) {
		super();
		this.artRepo = artRepo;
		this.venteRepo = venteRepo;
		this.ligVenteRepo = ligVenteRepo;
		this.venteMap = venteMap;
		this.LigventeMap = ligventeMap;
	}

	@Override
	public VentesDto save(VentesDto ventesDto) {
		ventesDto.getLigneVentesDto().forEach(ligneVenteDto->{
			Optional<Article> article= artRepo.findById(ligneVenteDto.getArticleDto().getId());
			if(!article.isPresent()) {
				log.error("Vente n'est pas valide");
				throw new InvalidEntityException("Vente non valide",ErrorCodes.INVALID_VENTE);
			}
		});
		Ventes savedVente=venteRepo.save(venteMap.fromDtoToEntity(ventesDto));
		ventesDto.getLigneVentesDto().forEach(ligneVenteDto->{
			LigneVente ligneVente=LigventeMap.fromDtoToEntity(ligneVenteDto);
			ligneVente.setVente(savedVente);
			ligVenteRepo.save(ligneVente);
		});
		return ventesDto;
	}

	@Override
	public VentesDto findById(Integer id) {
		if(id==null) {
			log.error("id vente est null");
			return null;
		}
		Optional<Ventes> vente=venteRepo.findById(id);
		if(vente.isPresent()) {
		return Optional.of(venteMap.fromEntityToDto(vente.get())).orElseThrow(()->new MapProblem("erreur de mappage", ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
			throw new EntityNotFoundException("entité non trouvé",ErrorCodes.VENTE_NOT_FOUND);
	}

	@Override
	public VentesDto findByCode(String code) {
		if(StringUtils.hasLength(code)) {
			log.error("code vente est null");
			return null;
		}
		Optional<Ventes> vente=venteRepo.findByCode(code);
		if(vente.isPresent()) {
		return Optional.of(venteMap.fromEntityToDto(vente.get())).orElseThrow(()->new MapProblem("erreur de mappage", ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
			throw new EntityNotFoundException("entité non trouvé",ErrorCodes.VENTE_NOT_FOUND);
	}

	@Override
	public List<VentesDto> findAll() {
		List<VentesDto> list=null;
		try {
			list=venteMap.fromEntitiesToDtoList(venteRepo.findAll());
		}
		catch(Exception e) {
			log.error("problème de list");
			throw new ListIsEmptyOrNullException("Liste vide ou null",ErrorCodes.LIST_EMPTY_OR_NULL);
		}
		return list;
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("id is null");
			return;
		}
		venteRepo.deleteById(id);
	}

}

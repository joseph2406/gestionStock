package tn.gestionstock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dao.ArticleRepository;
import tn.gestionstock.Dao.CommandeFournisseurRepository;
import tn.gestionstock.Dao.FournisseurRepository;
import tn.gestionstock.Dto.CommandeClientDto;
import tn.gestionstock.Dto.CommandeFournisseurDto;
import tn.gestionstock.entities.Article;
import tn.gestionstock.entities.CommandeClient;
import tn.gestionstock.entities.CommandeFournisseur;
import tn.gestionstock.entities.Fournisseur;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
import tn.gestionstock.exception.MapProblem;
import tn.gestionstock.mapper.CommandeFournisseurMapper;
@Service
@Slf4j
public class CommandeFournisseurImpl implements CommandeFournisseurService{
	private final CommandeFournisseurRepository cmdFourRepo;
	private final CommandeFournisseurMapper cmdFourMap;
	private final FournisseurRepository fourRepo;
	private final ArticleRepository artRepo;
	
	public CommandeFournisseurImpl(CommandeFournisseurRepository cmdFourRepo, CommandeFournisseurMapper cmdFourMap,
			FournisseurRepository fourRepo, ArticleRepository artRepo) {
		super();
		this.cmdFourRepo = cmdFourRepo;
		this.cmdFourMap = cmdFourMap;
		this.fourRepo = fourRepo;
		this.artRepo = artRepo;
	}

	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
		Optional<Fournisseur> four=fourRepo.findById(commandeFournisseurDto.getFournisseur().getId());
		if(!four.isPresent()) {
			log.error("Commande fournisseur n'est pas valide");
			throw new InvalidEntityException("Aucun Fournisseur avec l'id="+commandeFournisseurDto.getFournisseur().getId(), 
					ErrorCodes.FOURNISSEUR_NOT_FOUND);
		}
		if(commandeFournisseurDto.getLigneCommandeFournisseurs()!=null) {
			commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(ligCmdFour->{
				if(ligCmdFour.getArticle()!=null) {
					Optional<Article> art=artRepo.findById(ligCmdFour.getArticle().getId());
					if(!art.isPresent()) {
						log.error("article non trouvé avec l'id",ligCmdFour.getArticle().getId());
						throw new InvalidEntityException("article non trouvé avec l'id="+ligCmdFour.getArticle().getId(), 
								ErrorCodes.ARTICLE_NOT_FOUND);
					}
				}
				else {
					log.error("article non trouvé avec l'id",ligCmdFour.getArticle().getId());
				throw new InvalidEntityException("article non trouvé avec l'id="+ligCmdFour.getArticle().getId(), 
						ErrorCodes.ARTICLE_NOT_FOUND);}
			});
			try {
			cmdFourRepo.save(cmdFourMap.fromDtoToEntity(commandeFournisseurDto));
			}
			catch(Exception e) {
				log.error("Problème enregistrement");
				throw new MapProblem("erreur de mappage", ErrorCodes.MAP_IMPOSSIBLE);
			}
		}
		return commandeFournisseurDto;
	}

	@Override
	public CommandeFournisseurDto findById(Integer id) {
		if(id==null) {
			log.error("id commnde client est null");
			return null;
		}
		
		Optional<CommandeFournisseur> cmdFour=cmdFourRepo.findById(id);
		if(cmdFour.isPresent()) {
			return Optional.of(cmdFourMap.fromEntityToDto(cmdFour.get())).orElseThrow(()->new MapProblem("Erreur de mappage", 
					ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
			throw new EntityNotFoundException("Entité non trouvé", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
	}

	@Override
	public CommandeFournisseurDto findByCode(String code) {
		if(StringUtils.hasLength(code)) {
			log.error("Code est null");
			return null;
		}
		Optional<CommandeFournisseur> cmdFour=cmdFourRepo.findByCode(code);
		if(cmdFour.isPresent()) {
			return Optional.of(cmdFourMap.fromEntityToDto(cmdFour.get())).orElseThrow(()->new MapProblem("Erreur de mappage", 
					ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
			throw new EntityNotFoundException("Entité non trouvé"+code, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
	}

	@Override
	public List<CommandeFournisseurDto> findAll() {
		List<CommandeFournisseurDto> list=null;
		try {
			list=cmdFourMap.fromEntitiesToDtoList(cmdFourRepo.findAll());
			}
		catch(Exception e) {
			throw new  MapProblem("Erreur de mappage", 
					ErrorCodes.MAP_IMPOSSIBLE);
		}
			return  list;
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("id commnde client est null");
			return;
		}
		cmdFourRepo.deleteById(id);
		
	}

}

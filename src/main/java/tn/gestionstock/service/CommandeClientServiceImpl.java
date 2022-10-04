package tn.gestionstock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dao.ArticleRepository;
import tn.gestionstock.Dao.ClientRepository;
import tn.gestionstock.Dao.CommandeClientRepository;
import tn.gestionstock.Dto.CommandeClientDto;
import tn.gestionstock.entities.Article;
import tn.gestionstock.entities.Client;
import tn.gestionstock.entities.CommandeClient;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
import tn.gestionstock.exception.MapProblem;
import tn.gestionstock.mapper.CommandeClientMapper;
@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService{
	private final CommandeClientRepository cmdCltRepo;
	private final CommandeClientMapper cmdCltMap;
	private final ClientRepository cltRepo;
	private final ArticleRepository artRepo;
	

	public CommandeClientServiceImpl(CommandeClientRepository cmdCltRepo, CommandeClientMapper cmdCltMap,
			ClientRepository cltRepo, ArticleRepository artRepo) {
		super();
		this.cmdCltRepo = cmdCltRepo;
		this.cmdCltMap = cmdCltMap;
		this.cltRepo = cltRepo;
		this.artRepo = artRepo;
	}

	@Override
	public CommandeClientDto save(CommandeClientDto commandeClientDto) {
		Optional<Client> clt=cltRepo.findById(commandeClientDto.getClient().getId());
		if(!clt.isPresent()) {
			log.error("Commande Client n'est pas valide");
			throw new InvalidEntityException("Aucun Client avec l'id="+commandeClientDto.getClient().getId(), 
					ErrorCodes.CLIENT_NOT_FOUND);
		}
		if(commandeClientDto.getLigneCommandeClients()!=null) {
			commandeClientDto.getLigneCommandeClients().forEach(ligCmdClt->{
				if(ligCmdClt.getArticle()!=null) {
					Optional<Article> art=artRepo.findById(ligCmdClt.getArticle().getId());
					if(!art.isPresent()) {
						log.error("article non trouvé avec l'id",ligCmdClt.getArticle().getId());
						throw new InvalidEntityException("article non trouvé avec l'id="+ligCmdClt.getArticle().getId(), 
								ErrorCodes.ARTICLE_NOT_FOUND);
					}
				}
				else {
					log.error("article non trouvé avec l'id",ligCmdClt.getArticle().getId());
				throw new InvalidEntityException("article non trouvé avec l'id="+ligCmdClt.getArticle().getId(), 
						ErrorCodes.ARTICLE_NOT_FOUND);}
			});
			try {
			cmdCltRepo.save(cmdCltMap.fromDtoToEntity(commandeClientDto));
			}
			catch(Exception e) {
				log.error("Problème enregistrement");
				throw new MapProblem("erreur de mappage", ErrorCodes.MAP_IMPOSSIBLE);
			}
		}
		return commandeClientDto;
	}

	@Override
	public CommandeClientDto findById(Integer id) {
		if(id==null) {
			log.error("id commnde client est null");
			return null;
		}
		
		Optional<CommandeClient> cmdClt=cmdCltRepo.findById(id);
		if(cmdClt.isPresent()) {
			return Optional.of(cmdCltMap.fromEntityToDto(cmdClt.get())).orElseThrow(()->new MapProblem("Erreur de mappage", 
					ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
			throw new EntityNotFoundException("Entité non trouvé", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND);
	}

	@Override
	public CommandeClientDto findByCode(String code) {
		if(StringUtils.hasLength(code)) {
			log.error("Code est null");
			return null;
		}
		Optional<CommandeClient> cmdClt=cmdCltRepo.findByCode(code);
		if(cmdClt.isPresent()) {
			return Optional.of(cmdCltMap.fromEntityToDto(cmdClt.get())).orElseThrow(()->new MapProblem("Erreur de mappage", 
					ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
			throw new EntityNotFoundException("Entité non trouvé"+code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND);
	}

	@Override
	public List<CommandeClientDto> findAll() {
		List<CommandeClientDto> list=null;
	try {
		list=cmdCltMap.fromEntitiesToDtoList(cmdCltRepo.findAll());
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
		cmdCltRepo.deleteById(id);
	}

}

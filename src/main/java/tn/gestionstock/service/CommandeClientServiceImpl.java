package tn.gestionstock.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dao.ArticleRepository;
import tn.gestionstock.Dao.ClientRepository;
import tn.gestionstock.Dao.CommandeClientRepository;
import tn.gestionstock.Dao.LigneCommandeClientRepository;
import tn.gestionstock.Dto.CommandeClientDto;
import tn.gestionstock.entities.Article;
import tn.gestionstock.entities.Client;
import tn.gestionstock.entities.CommandeClient;
import tn.gestionstock.entities.EtatCommande;
import tn.gestionstock.entities.LigneCommandeClient;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
import tn.gestionstock.exception.InvalidOperationException;
import tn.gestionstock.exception.MapProblem;
import tn.gestionstock.mapper.ClientMapper;
import tn.gestionstock.mapper.CommandeClientMapper;
@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService{
	private final CommandeClientRepository cmdCltRepo;
	private final CommandeClientMapper cmdCltMap;
	private final ClientRepository cltRepo;
	private final ArticleRepository artRepo;
	private final LigneCommandeClientRepository ligRepo;
	private final ClientMapper cltMap;
	public CommandeClientServiceImpl(CommandeClientRepository cmdCltRepo, CommandeClientMapper cmdCltMap,
			ClientRepository cltRepo, ArticleRepository artRepo, LigneCommandeClientRepository ligRepo,
			ClientMapper cltMap) {
		super();
		this.cmdCltRepo = cmdCltRepo;
		this.cmdCltMap = cmdCltMap;
		this.cltRepo = cltRepo;
		this.artRepo = artRepo;
		this.ligRepo = ligRepo;
		this.cltMap = cltMap;
	}

	@Override
	public CommandeClientDto save(CommandeClientDto commandeClientDto) {
		Optional<Client> clt=cltRepo.findById(commandeClientDto.getClient().getId());
		if(!clt.isPresent()) {
			log.error("Commande Client n'est pas valide");
			throw new InvalidEntityException("Aucun Client avec l'id="+commandeClientDto.getClient().getId(), 
					ErrorCodes.CLIENT_NOT_FOUND);
		}
		if(commandeClientDto.getId()!=null && commandeClientDto.isCommandeLivree()) {
			throw new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est livré", 
					ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
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

	@Override
	public CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
			checkIdCommande(idCommande);
			if(StringUtils.hasLength(String.valueOf(etatCommande))) {
				log.error("id commnde client est null");
				throw new InvalidOperationException("impossible de modifer l'etat commande avec un id null"
						, ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
			}
			CommandeClientDto commandeClient=checkEtatCommande(idCommande);
			commandeClient.setEtatCommande(etatCommande);
		return cmdCltMap.fromEntityToDto(cmdCltRepo.save(cmdCltMap.fromDtoToEntity(commandeClient)));
	}

	@Override
	public CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer IdLigneCommande, BigDecimal qte) {
		checkIdCommande(idCommande);
		checkIdLigneCommande(IdLigneCommande);
		if(qte == null || qte.compareTo(BigDecimal.ZERO) == 0) {
			log.error("la quantité de commande est null");
			throw new InvalidOperationException("impossible de modifer la commande la quantité est null"
					, ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
		}
		CommandeClientDto commandeClient=checkEtatCommande(idCommande);
		Optional<LigneCommandeClient> ligneCmd=findLigneCommandeClient(IdLigneCommande);
		LigneCommandeClient ligneCmdClient=ligneCmd.get();
		ligneCmdClient.setQuantite(qte);
		ligRepo.save(ligneCmdClient);
		return commandeClient;
	}

	@Override
	public CommandeClientDto updateClientCommande(Integer idCommande, Integer idClient) {
		CommandeClientDto cmdClient=cmdCltMap.fromEntityToDto(cmdCltRepo.findById(idCommande).get());
		Optional<Client> client=cltRepo.findById(idClient);
		cmdClient.setClient(cltMap.fromEntityToDto(client.get()));
		return cmdCltMap.fromEntityToDto(cmdCltRepo.save(cmdCltMap.fromDtoToEntity(cmdClient)));
	}

	@Override
	public CommandeClientDto updateArticleCommande(Integer idCommande, Integer idLigneCommande,Integer newArticle) {
		checkIdCommande(idCommande);
		checkIdLigneCommande(idLigneCommande);
		checkIdArticle(newArticle,"nouveau");
		CommandeClientDto commandeClient=checkEtatCommande(idCommande);
		Optional<LigneCommandeClient> ligCommClient=findLigneCommandeClient(idLigneCommande);
		Optional<Article> articleOptional = artRepo.findById(newArticle);
		if(!articleOptional.isPresent()) {
			throw new EntityNotFoundException("Aucun article n'a été trouvé avec l'Id"+ newArticle,ErrorCodes.ARTICLE_NOT_FOUND);
		}
		ligCommClient.get().setArticle(articleOptional.get());
		ligRepo.save(ligCommClient.get());
		return commandeClient;
	}
private void checkIdCommande(Integer idCommande) {
	if(idCommande == null) {
		log.error("id commnde client est null");
		throw new InvalidOperationException("impossible de modifer l'etat commande avec un id null"
				, ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
	}
}
private void checkIdLigneCommande(Integer idLigneCommande) {
	if(idLigneCommande == null) {
		log.error("id ligne commande client est null");
		throw new InvalidOperationException("impossible de modifer l'etat commande avec un id null"
				, ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
	}
}
private void checkIdArticle(Integer idArticle,String msg) {
	if(idArticle == null) {
		log.error("id Article commande client est null");
		throw new InvalidOperationException("impossible de modifer l'etat commande avec un "+msg+ " id article null"
				, ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
	}
}
private CommandeClientDto checkEtatCommande(Integer idCommande) {
	CommandeClientDto commandeClient=findById(idCommande);
	if(commandeClient.isCommandeLivree()) {
		throw new InvalidOperationException("impossible de modifer la commande lorsqu'elle est livrée"
				, ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
	}
	return commandeClient;
}
private Optional<LigneCommandeClient> findLigneCommandeClient(Integer idLigneCommande){
	Optional<LigneCommandeClient> ligneCmd=ligRepo.findById(idLigneCommande);
	if(!ligneCmd.isPresent()) {
		throw new EntityNotFoundException("Aucune ligne commande avec l'id "+idLigneCommande,ErrorCodes.LIGNE_COMMANDE_CLIENT_NOT_FOUND);
	}
	return ligneCmd;
	
}
}

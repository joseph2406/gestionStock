package tn.gestionstock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dao.UtilisateurRepository;
import tn.gestionstock.Dto.UtilisateurDto;
import tn.gestionstock.entities.Utilisateur;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
import tn.gestionstock.exception.ListIsEmptyOrNullException;
import tn.gestionstock.exception.MapProblem;
import tn.gestionstock.mapper.UtilisateurMapper;
@Service
@Slf4j
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService{
	private final UtilisateurRepository utilRepo;
	private final UtilisateurMapper utilMap;
	
	public UtilisateurServiceImpl(UtilisateurRepository utilRepo, UtilisateurMapper utilMap) {
		super();
		this.utilRepo = utilRepo;
		this.utilMap = utilMap;
	}

	@Override
	public UtilisateurDto save(UtilisateurDto utilisateur) {
		Utilisateur util=null;
		try {
			util=utilMap.fromDtoToEntity(utilisateur);
			utilRepo.save(util);	
			log.error("Uitlisateur enregistré");
		}
		catch(Exception e) {
			  log.error("Entité Uitlisateur  invalide");
			  throw new InvalidEntityException("Utilisateur non valide",
			  ErrorCodes.UTILISATEUR_NOT_VALID);
		}
		return utilisateur;
	}

	@Override
	public UtilisateurDto findById(Integer id) {
		Optional<Utilisateur> util=utilRepo.findById(id);
		if(util.isPresent()) {
			return Optional.of(utilMap.fromEntityToDto(util.get())).orElseThrow(
					()->new MapProblem("Problème de Mappage",ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
			throw new EntityNotFoundException("Utilisateur non trouvé", ErrorCodes.UTILISATEUR_NOT_FOUND);
	}

	@Override
	public List<UtilisateurDto> findAll() {
		List<UtilisateurDto> listUtil=null;
		try {
			 listUtil=utilMap.fromEntitiesToDtoList(utilRepo.findAll());
			 if(ObjectUtils.isEmpty(listUtil)) {
					throw new ListIsEmptyOrNullException("Liste Vide ou Null",ErrorCodes.LIST_EMPTY_OR_NULL);
				}
		}
		catch(Exception e){
			throw new MapProblem("Problème de Mappage", ErrorCodes.MAP_IMPOSSIBLE);
		}
		return listUtil;
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("id est null",id);
			return;
		}
		utilRepo.deleteById(id);
	}

	@Override
	public UtilisateurDto findByEmail(String mail) {
		if(!StringUtils.hasLength(mail))
			log.error("mail est null");
		UtilisateurDto utilisateur=null;
		try {
			utilisateur=utilMap.fromEntityToDto(utilRepo.findByEmail(mail).get());
		}
		catch(Exception e) {
			throw new MapProblem("Problème de Mappage", ErrorCodes.MAP_IMPOSSIBLE);
		}
		return utilisateur;
	}

}

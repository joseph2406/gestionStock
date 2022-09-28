package tn.gestionstock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dao.EntrepriseRepository;
import tn.gestionstock.Dto.EntrepriseDto;
import tn.gestionstock.entities.Entreprise;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
import tn.gestionstock.exception.ListIsEmptyOrNullException;
import tn.gestionstock.exception.MapProblem;
import tn.gestionstock.mapper.EntrepriseMapper;
@Service
@Slf4j
@Transactional
public class EntrepriseServiceImpl implements EntrepriseService{
	private final EntrepriseRepository entRepo;
	private final EntrepriseMapper entMap;
	
	public EntrepriseServiceImpl(EntrepriseRepository entRepo, EntrepriseMapper entMap) {
		super();
		this.entRepo = entRepo;
		this.entMap = entMap;
	}

	@Override
	public EntrepriseDto save(EntrepriseDto entreprise) {
		Entreprise entrep=null;
		try {
			entrep=this.entMap.fromDtoToEntity(entreprise);
			entRepo.save(entrep);
			log.error("Entreprise created with id {}"+entrep.getId());
		}
		catch(Exception e) {
			log.error("Entreprise is not valid");
			throw new InvalidEntityException("Entreprise non valide", ErrorCodes.ENTREPRISE_NOT_VALID);
		}
		return entreprise;
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		if(id==null) {
			log.error("id is null {}",id);
			return null;
		}
		Optional<Entreprise> entr=entRepo.findById(id);
		if(entr.isPresent()) {
			return Optional.of(entMap.fromEntityToDto(entr.get())).orElseThrow(()->new MapProblem("Mappage impossible l'ip="+id+"",ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
			throw new EntityNotFoundException("Entreprise non trouvé avec l'id={}"+id,ErrorCodes.ENTREPRISE_NOT_FOUND);
	}

	@Override
	public List<EntrepriseDto> findAll() {
		List<EntrepriseDto> listEnt=null;
		try {
			listEnt=entMap.fromEntitiesToDtoList(entRepo.findAll());
			return listEnt;
		}
		catch(Exception e) {
			log.error("problème de list");
			throw new ListIsEmptyOrNullException("Liste vide ou null",ErrorCodes.LIST_EMPTY_OR_NULL);
		}
		
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("id is null {}",id);
			return;
		}
		try {
			entRepo.deleteById(id);
		}
		catch(Exception e) {
			throw new EntityNotFoundException("Entreprise non trouvé avec l'id={}"+id,ErrorCodes.ENTREPRISE_NOT_FOUND);
		}
	}

}

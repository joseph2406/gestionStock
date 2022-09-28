package tn.gestionstock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dao.ClientRepository;
import tn.gestionstock.Dto.ClientDto;
import tn.gestionstock.entities.Client;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
import tn.gestionstock.exception.ListIsEmptyOrNullException;
import tn.gestionstock.exception.MapProblem;
import tn.gestionstock.mapper.ClientMapper;
@Service
@Slf4j
@Transactional
public class ClientServiceImpl implements ClientService{
	private final ClientRepository cltRepo;
	private final ClientMapper cltMap;
	

	public ClientServiceImpl(ClientRepository cltRepo, ClientMapper cltMap) {
		super();
		this.cltRepo = cltRepo;
		this.cltMap = cltMap;
	}

	@Override
	public ClientDto save(ClientDto clientDto) {
		try {
			Client client=cltMap.fromDtoToEntity(clientDto);
			cltRepo.save(client);
			log.error("Client saved with id={}",client.getId());
		}
		catch(Exception e) {
			log.error("Client is not valid");
			throw new InvalidEntityException("Entité non valide", ErrorCodes.CLIENT_NOT_VALID);
		}
		return clientDto;
	}

	@Override
	public ClientDto findById(Integer id) {
		if(id==null) {
			log.error("id is null {}",id);
			return null;
		}
		Optional<Client> client=cltRepo.findById(id);
		if(client.isPresent()) {
		return Optional.of(cltMap.fromEntityToDto(client.get())).orElseThrow(()-> new MapProblem("Problème Mappage", ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
			throw new EntityNotFoundException("Entité inexistant", ErrorCodes.CLIENT_NOT_FOUND);
	}

	@Override
	public List<ClientDto> findAll() {
		List<ClientDto> listClt=null;
		try {
			listClt=cltMap.fromEntitiesToDtoList(cltRepo.findAll());
		}
		catch(Exception e) {
			throw new ListIsEmptyOrNullException("Liste Vide ou Null",ErrorCodes.LIST_EMPTY_OR_NULL);
		}
		return listClt;
	}

	@Override
	public void delete(Integer id) {
		try {
			if(id == null) {
				log.error("Article id is null");
				return;
			}
			cltRepo.deleteById(id);
		}
		catch(Exception e) {
			throw new EntityNotFoundException("Client non existant",ErrorCodes.CLIENT_NOT_FOUND);
		}
		
	}

}

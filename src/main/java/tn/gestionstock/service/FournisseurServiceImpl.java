package tn.gestionstock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dao.FournisseurRepository;
import tn.gestionstock.Dto.FournisseurDto;
import tn.gestionstock.entities.Fournisseur;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
import tn.gestionstock.mapper.FournisseurMapper;
@Service
@Slf4j
@Transactional
public class FournisseurServiceImpl implements FournisseurService {
	private final FournisseurRepository fourRepo;
	private final FournisseurMapper fourMap;
	
	public FournisseurServiceImpl(FournisseurRepository fourRepo, FournisseurMapper fourMap) {
		super();
		this.fourRepo = fourRepo;
		this.fourMap = fourMap;
	}

	@Override
	public FournisseurDto save(FournisseurDto fournisseurDto) {
		try {
			Fournisseur four=fourMap.fromDtoToEntity(fournisseurDto);
			fourRepo.save(four);
			log.error("Fournisseur saved with id {}"+four.getId());
		}
		catch(Exception e) {
			throw new InvalidEntityException("Entité non valide", ErrorCodes.FOURNISSEUR_NOT_VALID);
		}
		return null;
	}

	@Override
	public FournisseurDto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FournisseurDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}

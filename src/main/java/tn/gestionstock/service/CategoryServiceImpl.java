package tn.gestionstock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.gestionstock.Dao.CategoryRepository;
import tn.gestionstock.Dto.CategoryDto;
import tn.gestionstock.entities.Category;
import tn.gestionstock.exception.EntityNotFoundException;
import tn.gestionstock.exception.ErrorCodes;
import tn.gestionstock.exception.InvalidEntityException;
import tn.gestionstock.exception.ListIsEmptyOrNullException;
import tn.gestionstock.exception.MapProblem;
import tn.gestionstock.mapper.CategoryMapper;
@Service
@Slf4j
@Transactional
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository catRepo;
	private final CategoryMapper catMap;
	
	public CategoryServiceImpl(CategoryRepository catRepo, CategoryMapper catMap) {
		super();
		this.catRepo = catRepo;
		this.catMap = catMap;
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		try {
			Category category=catMap.fromDtoToEntity(categoryDto);
			catRepo.saveAndFlush(category);
			log.error("Category saved {}",category.getId());
		}
		catch(Exception e) {
			log.error("category non valide");
			throw new InvalidEntityException("Category Non Valide",ErrorCodes.CATEGORY_NOT_VALID);
		}
		return categoryDto;
	}

	@Override
	public CategoryDto findById(Integer id) {
		if(id==null) {
			log.error("id is null {}",id);
			return null;
		}
		Optional<Category> category=catRepo.findById(id);
		if(category.isPresent()) {
			return Optional.of(catMap.fromEntityToDto(category.get())).orElseThrow(()->new MapProblem("Problem de mappage", ErrorCodes.MAP_IMPOSSIBLE));
		}
		else
		throw new EntityNotFoundException("Category non Trouvé", ErrorCodes.CATEGORY_NOT_FOUND);
	}

	@Override
	public List<CategoryDto> listCategory() {
		List <CategoryDto> listCat=null;
		try {
		listCat=catMap.fromEntitiesToDtoList(catRepo.findAll());
		}
		catch (Exception e) {
			log.error("problème de list");
			throw new ListIsEmptyOrNullException("Liste vide ou null",ErrorCodes.LIST_EMPTY_OR_NULL);
		}
		
		return listCat;
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("id is null {}",id);
			return;
		}
		catRepo.deleteById(id);
	}

}

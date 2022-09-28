package tn.gestionstock.service;

import java.util.List;

import tn.gestionstock.Dto.CategoryDto;

public interface CategoryService {
	CategoryDto save(CategoryDto categoryDto);
	CategoryDto findById(Integer id);
	List<CategoryDto> listCategory();
	void delete(Integer id);
	

}

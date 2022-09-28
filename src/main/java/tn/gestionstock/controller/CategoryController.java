package tn.gestionstock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import tn.gestionstock.Dto.CategoryDto;
import tn.gestionstock.service.CategoryService;
@RestController
public class CategoryController implements CategoryApi{
	private CategoryService catService;
	
	public CategoryController(CategoryService catService) {
		super();
		this.catService = catService;
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {

		return catService.save(categoryDto);
	}

	@Override
	public CategoryDto findById(Integer id) {
		return catService.findById(id);
	}

	@Override
	public List<CategoryDto> listCategory() {
		
		return catService.listCategory();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}

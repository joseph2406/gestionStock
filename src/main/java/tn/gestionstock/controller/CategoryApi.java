package tn.gestionstock.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.gestionstock.Dto.CategoryDto;
import static tn.gestionstock.utils.Constant.APP_ROOT;

public interface CategoryApi {
	@PostMapping(value=APP_ROOT+"/Category/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
	CategoryDto save(@RequestBody CategoryDto categoryDto);
	@GetMapping(value=APP_ROOT+"/Category/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	CategoryDto findById(@PathVariable Integer id);
	@GetMapping(value=APP_ROOT+"/Category/all",produces = MediaType.APPLICATION_JSON_VALUE)
	List<CategoryDto> listCategory();
	@GetMapping(value=APP_ROOT+"/Category/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	void delete(@PathVariable Integer id);
}

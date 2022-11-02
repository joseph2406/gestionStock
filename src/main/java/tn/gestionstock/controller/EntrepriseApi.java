package tn.gestionstock.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import tn.gestionstock.Dto.EntrepriseDto;
import static tn.gestionstock.utils.Constant.APP_ROOT;
@Api("APP_ROOT"+"/Entreprise")
public interface EntrepriseApi {
	@PostMapping(value = APP_ROOT+"/Entreprise/create" ,consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDto save(@RequestBody EntrepriseDto entreprise);
	@GetMapping(value = APP_ROOT+"/Entreprise/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDto findById(@PathVariable Integer id);
	@GetMapping(value = APP_ROOT+"/Entreprise/all",produces = MediaType.APPLICATION_JSON_VALUE)
	List<EntrepriseDto> findAll();
	@GetMapping(value = APP_ROOT+"/Entreprise/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	void delete(Integer id);
}

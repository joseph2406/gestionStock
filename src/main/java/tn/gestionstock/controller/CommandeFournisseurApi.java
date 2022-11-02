package tn.gestionstock.controller;

import static tn.gestionstock.utils.Constant.APP_ROOT;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.gestionstock.Dto.CommandeFournisseurDto;
@Api(APP_ROOT+"commandesFournisseurs")
public interface CommandeFournisseurApi {
	@PostMapping(APP_ROOT+"/commandeFournisseur/create")
	CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto commandeFournisseurDto);
	@GetMapping(APP_ROOT+"/commandeFournisseur/findByid/{id}")
	CommandeFournisseurDto findById(@PathVariable Integer id);
	@GetMapping(APP_ROOT+"/commandeFournisseur/findByCode/{code}")
	CommandeFournisseurDto findByCode(String code);
	@GetMapping(APP_ROOT+"/commandeFournisseur/findAll")
	List<CommandeFournisseurDto> findAll();
	@DeleteMapping(APP_ROOT+"/commandeFournisseur/delete/{id}")
	void delete(@PathVariable Integer id);

}

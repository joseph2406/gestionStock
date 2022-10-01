package tn.gestionstock.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.gestionstock.Dto.UtilisateurDto;
import static tn.gestionstock.utils.Constant.APP_ROOT;
public interface UtilisateurApi {
	@PostMapping(value=APP_ROOT+"/Utilisateur/save",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDto save(@RequestBody UtilisateurDto utilisateur);
	@GetMapping(value=APP_ROOT+"/Utilisateur/find/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDto findById(@PathVariable Integer id);
	@GetMapping(value=APP_ROOT+"/Utilisateur/findAll",produces=MediaType.APPLICATION_JSON_VALUE)
	List<UtilisateurDto> findAll();
	@GetMapping(value = APP_ROOT+"/Utilisateur/delete/{id}")
	void delete(@PathVariable Integer id);
	

}

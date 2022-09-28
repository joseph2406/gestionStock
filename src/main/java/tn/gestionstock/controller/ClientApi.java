package tn.gestionstock.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.gestionstock.Dto.ClientDto;
import static tn.gestionstock.utils.Constant.APP_ROOT;

public interface ClientApi {
	@PostMapping(value= APP_ROOT+"/Client/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ClientDto save(@RequestBody ClientDto clientDto);
	@GetMapping(value = APP_ROOT+"/Client/find/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	ClientDto findById(@PathVariable Integer id);
	@GetMapping(value = APP_ROOT+"/Client/findAll",produces=MediaType.APPLICATION_JSON_VALUE)
	List<ClientDto> findAll();
	@GetMapping(value = APP_ROOT+"/Client/delete/{id}")
	void delete(@PathVariable Integer id);
}

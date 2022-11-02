package tn.gestionstock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.gestionstock.Dto.VentesDto;
import static tn.gestionstock.utils.Constant.VENTES_END_POINT;
@Api(VENTES_END_POINT)
public interface VentesApi {
	@PostMapping(VENTES_END_POINT+"/create")
	VentesDto save(@RequestBody VentesDto ventesDto);
	@GetMapping(VENTES_END_POINT+"/findBy/{id}")
	VentesDto findById(@PathVariable Integer id);
	@GetMapping(VENTES_END_POINT+"/findByCode/{code}")
	VentesDto findByCode(@PathVariable String code);
	@GetMapping(VENTES_END_POINT+"/findAll")
	List<VentesDto> findAll();
	@DeleteMapping(VENTES_END_POINT+"/delete/{id}")
	void delete(@PathVariable Integer id);
}

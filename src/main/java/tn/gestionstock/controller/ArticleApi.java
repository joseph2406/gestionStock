package tn.gestionstock.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import tn.gestionstock.Dto.ArticleDto;
import static tn.gestionstock.utils.Constant.APP_ROOT;
@Api(APP_ROOT+"/Articles")
public interface ArticleApi {
	@PostMapping(value=APP_ROOT+"/Articles/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Enregistrer ou modifier un article",response = ArticleDto.class)
	@ApiResponses(value= {
			@ApiResponse(responseCode =" 200", description ="article enregistré avec succées")
	})
	ArticleDto save(@RequestBody ArticleDto article);
	@GetMapping(value = APP_ROOT+"/Article/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	ArticleDto findById(@PathVariable Integer id);
	@GetMapping(value = APP_ROOT+"/Articlebycode/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
	ArticleDto findByCodeArticle(@PathVariable String code);
	@GetMapping(value = APP_ROOT+"/Article/all",produces = MediaType.APPLICATION_JSON_VALUE)
	List<ArticleDto> findAll();
	@GetMapping(value = APP_ROOT+"/Article/delete/{id}")
	void delete(@PathVariable Integer id);

}

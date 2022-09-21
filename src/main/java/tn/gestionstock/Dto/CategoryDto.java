package tn.gestionstock.Dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CategoryDto {
	private Integer id;
	private String code;
	private String designation;
	private List<ArticleDto> articles;
}

package tn.gestionstock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static tn.gestionstock.utils.Constant.APP_ROOT;
@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder()
				.description("Gestion de Stock Documentation")
				.title("Gestion de Stock Rest Api").build())
				.groupName("Rest Api V1")
				.select() 
				.apis(RequestHandlerSelectors.basePackage("tn.gestionstock"))
						.paths(PathSelectors.ant(APP_ROOT+"/**")).build();
		
	}
}

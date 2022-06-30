package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SwaggerConfig {
	private ApiKey jwtApiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext jwtSecurityContext() {
		return SecurityContext.builder()
				.securityReferences(Collections.singletonList(
						new SecurityReference("JWT", new AuthorizationScope[0])))
				.build();
	}

	private SecurityContext basicSecurityContext() {
		return SecurityContext.builder()
				.securityReferences(Collections.singletonList(
						new SecurityReference("Basic", new AuthorizationScope[0])))
				.build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(Arrays.asList(basicSecurityContext(), jwtSecurityContext()))
				.securitySchemes(Arrays.asList(new BasicAuth("Basic"), jwtApiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.backend.controllers"))
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Household Photo Archive")
				.version("3.0.0")
				.description("Back-end of Household Photo Archive Application. Maintains a family photo archive (photo album) for all cameras, phones of all family members")
				.license("License: Shareware || (MIT && (Linkware || Donateware || Beerware))")
				.licenseUrl("https://www.linkedin.com/in/andrew-miterev-9490b2b0/")
				.contact(new Contact("Andrew Miterev", "https://www.linkedin.com/in/andrew-miterev-9490b2b0/", "andrew.miterev@gmail.com"))
				.build();
	}
}
package com.lut.admin.core.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/7 14:50
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${swagger.enable}")
	Boolean enable;

	@Bean
	public Docket createApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(enable)
				.apiInfo(apiInfo())
				.groupName("spring boot 2.6")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.licon.domain.api"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("domain")
				.description("domain server")
				.version("V0.0.1.L1")
				.build();
	}
}

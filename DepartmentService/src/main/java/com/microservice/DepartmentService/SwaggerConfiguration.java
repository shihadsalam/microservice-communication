package com.microservice.DepartmentService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  @Value(value = "${swagger.app.title}")
  protected String title;
  @Value(value = "${swagger.app.description}")
  protected String description;
  @Value(value = "${swagger.app.version}")
  protected String version;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.microservice.DepartmentService"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(new ApiInfoBuilder()
            .title(title)
            .description(description)
            .version(version)
            .build());

  }
}

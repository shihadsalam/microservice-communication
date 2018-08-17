package com.microservice.SwaggerGatewayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableZuulProxy
@EnableSwagger2
public class SwaggerGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerGatewayServiceApplication.class, args);
	}
}

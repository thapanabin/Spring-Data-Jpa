package com.nabin.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication//openapi doc
@OpenAPIDefinition(info = @Info(title = "Product API",version = "2.1.2",description = "Product Microservices"))
public class SpringDataJpaMappinngApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaMappinngApplication.class, args);
	}

}

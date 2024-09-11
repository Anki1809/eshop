package com.eshop.productservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableDiscoveryClient
@OpenAPIDefinition(
		info = @Info(
				title = "Product-service",
				description = "E-Shop product microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Ankit Gupta",
						email = "iamankitgupta4321@gmail.com",
						url = "https://www.eshop.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.eshop.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "E-Shop product microservice REST API Documentation",
				url = "https://www.eshop.com/swagger-ui.html"
		)
)
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}

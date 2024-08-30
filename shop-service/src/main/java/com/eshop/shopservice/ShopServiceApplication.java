package com.eshop.shopservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Shop-service microservice REST API Documentation",
                description = "E-Shop shop microservice REST API Documentation",
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
                description =  "E-Shop shop microservice REST API Documentation",
                url = "https://www.eshop.com/swagger-ui.html"
        )
)
public class ShopServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServiceApplication.class, args);
    }

}

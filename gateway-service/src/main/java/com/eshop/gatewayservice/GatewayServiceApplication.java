package com.eshop.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    public RouteLocator eshopRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/shop/**")
                        .filters( f -> f.rewritePath("/shop/(?<segment>.*)","/${segment}")
                            .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://SHOP-SERVICE"))
                .route(p -> p
                .path("/product/**")
                        .filters( f -> f.rewritePath("/product/(?<segment>.*)","/${segment}")
                            .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://PRODUCT-SERVICE")).build();


    }
}

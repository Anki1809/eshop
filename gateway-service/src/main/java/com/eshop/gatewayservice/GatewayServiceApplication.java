package com.eshop.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

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
                            .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                        )
                        .uri("lb://SHOP-SERVICE"))
                .route(p -> p
                .path("/product/**")
                        .filters( f -> f.rewritePath("/product/(?<segment>.*)","/${segment}")
                            .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://PRODUCT-SERVICE")).build();


    }

    public String getUserIdFromToken( Jwt jwt) {

       /* JwtAuthenticationToken auth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Jwt jwt = auth.getToken();*/
            String userId = (String) jwt.getClaims().get("sub");
            if (userId == null || userId.isEmpty()){
                throw new RuntimeException("Invalid token");
            }
            System.out.println(userId);
            return userId;
       /* }
        System.out.println("auth");
        return "null";*/

    }
}

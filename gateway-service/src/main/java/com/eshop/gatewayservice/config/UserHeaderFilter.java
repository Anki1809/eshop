package com.eshop.gatewayservice.config;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class UserHeaderFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return UserContextUtil.getLoggedInUserId()
                .flatMap(userId -> {
                    // Add the user ID to the request headers
                    ServerWebExchange modifiedExchange = exchange.mutate()
                            .request(builder -> builder.header("X-User-Id", userId))
                            .build();
                    return chain.filter(modifiedExchange);
                });
    }
}

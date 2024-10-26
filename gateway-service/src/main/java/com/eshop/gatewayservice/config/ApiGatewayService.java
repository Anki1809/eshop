package com.eshop.gatewayservice.config;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiGatewayService {

    private final WebClient webClient;

    public ApiGatewayService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<String> forwardRequest(String url) {
        return UserContextUtil.getLoggedInUserId()
                .flatMap(userId ->
                        webClient.get()
                                .uri(url)
                                .header("X-User-Id", userId)
                                .retrieve()
                                .bodyToMono(String.class)
                );
    }
}

package com.eshop.gatewayservice.config;

import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Mono;

public class UserContextUtil {

    public static Mono<String> getLoggedInUserId() {
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .filter(auth -> auth != null && auth.getPrincipal() instanceof Jwt)
                .map(auth -> ((Jwt) auth.getPrincipal()).getSubject())
                .switchIfEmpty(Mono.error(new IllegalStateException("User not authenticated")));
    }
}

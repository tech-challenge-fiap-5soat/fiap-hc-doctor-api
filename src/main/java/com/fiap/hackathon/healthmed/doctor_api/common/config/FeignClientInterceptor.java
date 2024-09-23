package com.fiap.hackathon.healthmed.doctor_api.common.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class FeignClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && authentication.getCredentials() != null
                && authentication.getPrincipal() != "anonymousUser") {
            String token = ((JwtAuthenticationToken) authentication).getToken().getTokenValue();
            requestTemplate.header("Authorization", "Bearer " + token);
        }
    }
}

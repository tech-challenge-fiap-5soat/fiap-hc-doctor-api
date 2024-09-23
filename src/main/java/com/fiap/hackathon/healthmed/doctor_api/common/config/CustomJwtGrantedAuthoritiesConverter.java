package com.fiap.hackathon.healthmed.doctor_api.common.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.core.Authentication;
import java.util.Collection;

public class CustomJwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    private final JwtGrantedAuthoritiesConverter defaultGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {

        Collection<GrantedAuthority> authorities = defaultGrantedAuthoritiesConverter.convert(jwt);
        String userAuthType = jwt.getClaimAsString("custom:UserAuthType");
        if (userAuthType != null) {
            GrantedAuthority authority = new SimpleGrantedAuthority(userAuthType.toUpperCase());
            authorities.add(authority);
        }

        Authentication auth = createAuthenticationFromJwt(jwt, authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);
        return authorities;
    }

    public Authentication createAuthenticationFromJwt(Jwt jwt, Collection<GrantedAuthority> authorities) {
        return new UsernamePasswordAuthenticationToken(
                jwt.getSubject(),
                null,
                authorities
        );
    }
}

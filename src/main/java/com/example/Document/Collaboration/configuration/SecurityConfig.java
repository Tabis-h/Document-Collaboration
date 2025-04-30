package com.example.Document.Collaboration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // disable CSRF
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().permitAll() // allow all requests without login
                )
                .httpBasic().disable(); // disable HTTP Basic login popup
        return http.build();
    }
}

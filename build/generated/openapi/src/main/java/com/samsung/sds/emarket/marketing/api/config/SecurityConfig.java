package com.samsung.sds.emarket.marketing.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()  // Allow access to all paths
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF protection
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));  // Allow frames
        return http.build();
    }
}
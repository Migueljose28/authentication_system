package com.miguel.authenticationAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    

    @Bean
@Order(1)
public SecurityFilterChain authSecurityFilterChain(HttpSecurity http) throws Exception {
    http
        .securityMatcher("/auth/**") // atua apenas sobre /auth/**
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/**").permitAll()
        );
    return http.build();
}

@Bean
@Order(2)
public SecurityFilterChain userSecurityFilterChain(HttpSecurity http) throws Exception {
    http
        .securityMatcher("/users/**") // atua apenas sobre /users/**
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(users -> users
            .requestMatchers("/users/**").permitAll()
        );
    return http.build();
}

@Bean
@Order(3)
public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .anyRequest().authenticated()
        );
    return http.build();
}


    //Configuração do PasswordEncoder. hash da senha
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
}

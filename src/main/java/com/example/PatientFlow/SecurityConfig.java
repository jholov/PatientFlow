package com.example.PatientFlow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/patients/**").permitAll() // Allow access to this API
                        .anyRequest().authenticated() // Other routes remain secured
                )
                .csrf().disable() // Disable CSRF for API testing
                .formLogin().disable(); // Disable default login form

        return http.build();
    }
}
package com.project.product.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Habiltar a configuração, para eu configurar
public class ConfigSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Desativa o csrf
                // Faz aplicação ser stateless ( só roda quando é chamado )
                .sessionManagement(
                        (session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
                .build();
    }
    }
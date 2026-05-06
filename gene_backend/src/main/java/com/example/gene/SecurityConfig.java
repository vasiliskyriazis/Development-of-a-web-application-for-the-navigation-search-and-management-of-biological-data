package com.example.gene;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity 
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("🚨 SecurityConfig LOADED!");

        http
            .cors().and() // ενεργοποιούμε το CORS
            .csrf(csrf -> csrf.disable()) // API χωρίς CSRF
            .authorizeHttpRequests(auth -> auth
                // Προστατευμένα POST/PUT/DELETE (Admin μόνο)
                .requestMatchers(HttpMethod.POST, "/api/genes/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/genes/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/genes/**").hasRole("ADMIN")

                // Δημόσια GET endpoints
                .requestMatchers(HttpMethod.GET, "/api/genes/**").permitAll()
                .requestMatchers(HttpMethod.OPTIONS, "/api/genes/**").permitAll() // επιτρέπουμε τα preflight

                // Οτιδήποτε άλλο κόβεται
                .anyRequest().denyAll()
            )
            .httpBasic(); // Χρήση Basic Auth

        return http.build();
    }

    // CORS configuration για Angular frontend
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setExposedHeaders(List.of("Authorization")); 
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);
        return source;
    }

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
            .username("admin")
            .password("{noop}password123") // {noop} = χωρίς encoder (για testing)
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(admin);
    }
}

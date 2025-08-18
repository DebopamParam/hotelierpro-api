package com.hotelierpro.api.config;

import com.hotelierpro.api.security.JwtRequestFilter;
import com.hotelierpro.api.user.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod; // Import HttpMethod
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JpaUserDetailsService jpaUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(JpaUserDetailsService jpaUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.jpaUserDetailsService = jpaUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Rule 1: Public endpoints
                        .requestMatchers("/api/auth/**").permitAll()
                        // Rule 2: Anyone authenticated can view hotels
                        .requestMatchers(HttpMethod.GET, "/api/hotels/**").authenticated()
                        // Rule 3: Only MANAGERs can create hotels
                        .requestMatchers(HttpMethod.POST, "/api/hotels").hasRole("MANAGER")
                        // Rule 4: All other requests must be authenticated
                        .anyRequest().authenticated()
                )
                .userDetailsService(jpaUserDetailsService)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // ... passwordEncoder() and authenticationManager() beans are unchanged ...

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}



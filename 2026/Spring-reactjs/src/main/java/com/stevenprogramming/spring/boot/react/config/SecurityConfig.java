package com.stevenprogramming.spring.boot.react.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/**")
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/clients/").permitAll() // Allow unauthenticated access to /users endpoint
                                .requestMatchers("/clients/**").authenticated() // Require auth for all other /users endpoints
                                //.anyRequest().permitAll() // Allow all requests without auth
                                .anyRequest().authenticated() // Require auth for all requests
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public SecurityFilterChain filterChainLogin(HttpSecurity http) throws Exception {
        http
                .csrf(csrf ->
                        csrf.ignoringRequestMatchers("/h2-console/**"))
                .headers(headers -> headers.frameOptions(frameOptions ->
                        frameOptions.sameOrigin()))
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/h2-console/**").permitAll()
                )
                .formLogin(withDefaults());

        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }


//    @Bean
//    SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
//                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().authenticated())
//                .formLogin(withDefaults());
//
//        return http.build();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers("/login").permitAll()
//                        .anyRequest().authenticated()
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(
//            UserDetailsService userDetailsService,
//            PasswordEncoder passwordEncoder) {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder);
//
//        return new ProviderManager(authenticationProvider);
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }


}
package com.example.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}

// CSRF 보호를 끈다. (대신 JWT, SessionCookie, Token 기반 방식으로 보호)
// 모든 URL 요청은 인증(로그인)해야 한다. (로그인 안하면 로그인 페이지로 redirect)
// Postman 같은 곳에서 username과 password만 입력하면 인증 가능하게 해줌 (없으면 Basic Auth 요청보내도 인증 X)
// Spring Security에서 Session 사용 안함 = 완전 무상태(Stateless) 방식. JWT인증에서 주로 사용

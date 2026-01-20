package com.example.ecommerce.config;

import com.example.ecommerce.service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final MyUserDetailsService myUserDetailsService;

    public SecurityConfig(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

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
    // CSRF 보호를 끈다. (대신 JWT, SessionCookie, Token 기반 방식으로 보호)
    // 모든 URL 요청은 인증(로그인)해야 한다. (로그인 안하면 로그인 페이지로 redirect)
    // Postman 같은 곳에서 username과 password만 입력하면 인증 가능하게 해줌 (없으면 Basic Auth 요청보내도 인증 X)
    // Spring Security에서 Session 사용 안함 = 완전 무상태(Stateless) 방식. JWT인증에서 주로 사용

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(myUserDetailsService);

        return provider;
    }
    // Spring Security에게 DAO방식(Database 기반 인증)을 사용할 것이다.
    // 비밀번호 encoder 지정. 암호화 안함. 비밀번호를 평문 그대로 비교한다.
    // 내가 만든 myUserDetailsService를 provider에 연결
}

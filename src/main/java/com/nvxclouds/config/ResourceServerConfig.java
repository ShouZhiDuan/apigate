package com.nvxclouds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/4/3 14:54
 * @Description:
 */
@EnableWebFluxSecurity
public class ResourceServerConfig {

    private static final String[] antPatterns = {
            "/login",
            "/api/v1/user/login",
            "/api/v1/user/register"
    };

    @Bean
    public SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange()
                .pathMatchers(antPatterns).permitAll()
                .anyExchange().authenticated().and().csrf().disable();
        http.oauth2ResourceServer().jwt();
        return http.build();
    }


}

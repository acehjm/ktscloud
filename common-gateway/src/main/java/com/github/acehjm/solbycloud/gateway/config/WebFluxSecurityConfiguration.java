//package com.github.acehjm.solbycloud.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
///**
// * com.github.acehjm.solbycloud.gateway.config
// *
// * @author majhdk
// * @date 2019/12/30
// */
//@Configuration
//@EnableWebFluxSecurity
//public class WebFluxSecurityConfiguration {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
////        return http
////                .authorizeExchange()
////                .anyExchange().authenticated()
////                .and()
////                .httpBasic().disable()
////                .oauth2ResourceServer()
////                .jwt()
////                .and().and()
////                .build();
//        return http.csrf().disable().build();  // 禁用csrf
//    }
//
//}

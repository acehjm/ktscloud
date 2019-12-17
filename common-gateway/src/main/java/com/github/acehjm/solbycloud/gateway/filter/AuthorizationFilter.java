package com.github.acehjm.solbycloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.security.Principal;

/**
 * 授权校验
 * TODO add
 *
 * @author majhdk
 * @date 2019/12/5
 */
@Configuration
public class AuthorizationFilter {

    @Bean
    @Order(0) // 过滤器的执行顺序::数字越大表示优先级越低，越后执行
    public GlobalFilter authGlobalFilter() {
        return (exchange, chain) -> exchange.getPrincipal()
                .map(Principal::getName)
                .defaultIfEmpty("Default User")
                .map(userName -> {
                    //adds header to proxied request
                    exchange.getRequest().mutate().header("CUSTOM-REQUEST-HEADER", userName).build();
                    return exchange;
                })
                .flatMap(chain::filter);
    }

}

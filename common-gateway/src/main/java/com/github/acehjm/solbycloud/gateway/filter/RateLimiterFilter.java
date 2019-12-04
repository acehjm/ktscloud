package com.github.acehjm.solbycloud.gateway.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * 用户限流过滤器
 * TODO 从token获取用户
 *
 * @author majhdk
 * @date 2019/12/4
 */
@Configuration
public class RateLimiterFilter {

    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("user")));
    }

}

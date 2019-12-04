package com.github.acehjm.solbycloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;

/**
 * com.github.acehjm.solbycloud.gateway.filter
 *
 * @author majhdk
 * @date 2019/12/3
 */
@Slf4j
@Configuration
public class SolbyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        long start = Instant.now().toEpochMilli();
        return chain.filter(exchange)
                // then的内容会在过滤器返回的时候执行，即最后执行
                .then(Mono.fromRunnable(() ->
                        log.info("[{}] 接口的访问耗时：{}/ms", path, Instant.now().toEpochMilli() - start))
                );
    }

    @Override
    public int getOrder() {
        return -1;
    }
}

package com.github.acehjm.solbycloud.gateway.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;

/**
 * 授权校验
 *
 * @author majhdk
 * @date 2019/12/5
 */
@Configuration
public class AuthorizationFilter {

    private static final String Authorization = "Authorization";
    private static final String Bearer = "Bearer ";

    @Bean
    @Order(0) // 过滤器的执行顺序::数字越大表示优先级越低，越后执行
    public GlobalFilter authGlobalFilter() {
        return (exchange, chain) -> {
            String authorization = exchange.getRequest().getHeaders().getFirst(Authorization);
            if (StringUtils.isBlank(authorization)) {
                final String errorMsg = "服务未授权,请先获取授权";
                return handlerError(exchange, errorMsg);
            }
            String[] tokenSplit = authorization.split(Bearer);
            if (tokenSplit.length != 2 || StringUtils.isBlank(tokenSplit[1])) {
                final String errorMsg = "授权信息格式错误";
                return handlerError(exchange, errorMsg);
            }

            ResponseEntity<Object> entity = new RestTemplate()
                    .getForEntity("http://localhost:8902/oauth/check_token?token=" + tokenSplit[1], Object.class);

            return chain.filter(exchange);
        };
    }

    /**
     * 异常处理封装
     *
     * @param exchange 交换器
     * @param errorMsg 错误信息
     * @return
     */
    private Mono<Void> handlerError(ServerWebExchange exchange, String errorMsg) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(errorMsg.getBytes());
        return response.writeWith(Mono.just(bodyDataBuffer));
    }

}

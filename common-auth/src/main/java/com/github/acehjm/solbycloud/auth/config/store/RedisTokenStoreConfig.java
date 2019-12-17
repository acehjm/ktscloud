package com.github.acehjm.solbycloud.auth.config.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2RefreshToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * com.github.acehjm.solbycloud.auth.config
 *
 * @author majhdk
 * @date 2019/12/17
 */
@Configuration
public class RedisTokenStoreConfig {

//    @Bean
    public TokenEnhancer customTokenEnhancer() {
        return (accessToken, authentication) -> {
            DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(accessToken);
            DefaultOAuth2RefreshToken refreshToken = new DefaultOAuth2RefreshToken("custom_refresh_token");
            token.setRefreshToken(refreshToken);
            return token;
        };
    }

//    @Bean("tokenStore")
    public TokenStore tokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(lettuceConnectionFactory());
        tokenStore.setPrefix("oauth2:");
        return tokenStore;
    }

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        return new LettuceConnectionFactory();
    }

}

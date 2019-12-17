package com.github.acehjm.solbycloud.auth.config;

import com.github.acehjm.solbycloud.auth.constant.enums.GrantTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import static com.github.acehjm.solbycloud.auth.constant.AuthConstant.ACCESS_TOKEN_VALIDITY_SECONDS;
import static com.github.acehjm.solbycloud.auth.constant.AuthConstant.CLIENT_ID;
import static com.github.acehjm.solbycloud.auth.constant.AuthConstant.CLIENT_SECRET;
import static com.github.acehjm.solbycloud.auth.constant.AuthConstant.REFRESH_TOKEN_VALIDITY_SECONDS;
import static com.github.acehjm.solbycloud.auth.constant.AuthConstant.SCOPE_READ;
import static com.github.acehjm.solbycloud.auth.constant.AuthConstant.SCOPE_WRITE;
import static com.github.acehjm.solbycloud.auth.constant.AuthConstant.TRUST;

/**
 * com.github.acehjm.solbycloud.auth.config
 *
 * @author majhdk
 * @date 2019/12/14
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private TokenEnhancer jwtTokenEnhancer;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(CLIENT_ID)
                .secret(new BCryptPasswordEncoder().encode(CLIENT_SECRET))
                .authorizedGrantTypes(GrantTypeEnum.types())
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
                .refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .tokenStore(tokenStore)
                .tokenEnhancer(jwtTokenEnhancer)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

}

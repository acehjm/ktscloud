package com.github.acehjm.solbycloud.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * com.github.acehjm.solbycloud.boot
 *
 * @author majhdk
 * @date 2019/11/25
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}

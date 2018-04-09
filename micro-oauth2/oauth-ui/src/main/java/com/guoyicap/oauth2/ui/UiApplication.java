package com.guoyicap.oauth2.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by wuyu on 2016/9/10.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class UiApplication {
    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }
}

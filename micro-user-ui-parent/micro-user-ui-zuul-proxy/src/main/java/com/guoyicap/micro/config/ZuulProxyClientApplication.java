package com.guoyicap.micro.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wuyu on 2016/7/9.
 */
@SpringBootApplication
@EnableEurekaClient
public class ZuulProxyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulProxyClientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

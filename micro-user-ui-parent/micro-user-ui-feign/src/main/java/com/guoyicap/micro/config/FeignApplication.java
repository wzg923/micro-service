package com.guoyicap.micro.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.io.IOException;

/**
 * Created by wuyu on 2016/7/6.
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
@EnableRedisHttpSession
public class FeignApplication {
    public static void main(String[] args) throws IOException {

        SpringApplication.run(FeignApplication.class, args);
    }
}




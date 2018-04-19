package com.guoyicap.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by wuyu on 2016/9/9.
 */
@SpringBootApplication
@EnableRedisHttpSession
@EnableDiscoveryClient
@MapperScan(basePackages= {"com.guoyicap.oauth2.dao"})
public class OAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthServerApplication.class, args);
    }
}

package com.guoyicap.micro.route.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by wuyu on 2016/7/6.
 */
@SpringBootApplication
@EnableSidecar
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class,args);
    }
}

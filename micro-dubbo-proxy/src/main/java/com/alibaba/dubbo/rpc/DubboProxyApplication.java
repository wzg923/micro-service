package com.alibaba.dubbo.rpc;

import com.alibaba.dubbo.rpc.proxy.EnableDubboProxyAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wuyu on 2016/7/8.
 */
@SpringBootApplication
@EnableDubboProxyAutoConfiguration
@EnableEurekaClient
public class DubboProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProxyApplication.class, args);
    }
}

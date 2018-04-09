package com.guoyicap.micro.config;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages= {"com.guoyicap.micro.config.user.dao"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableSwagger2//see http://localhost:8080/swagger-ui.html
//@EnableDubboAutoConfiguration
public class UserApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(UserApplication.class, args);
    }

}

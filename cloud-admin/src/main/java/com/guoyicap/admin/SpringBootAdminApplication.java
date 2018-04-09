package com.guoyicap.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wuyu on 2016/9/16.
 */
@SpringBootApplication
@EnableAdminServer
@EnableEurekaClient
public class SpringBootAdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootAdminApplication.class, args);
    }
}

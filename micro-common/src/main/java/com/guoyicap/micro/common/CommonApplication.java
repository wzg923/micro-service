package com.guoyicap.micro.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Controller
@Configuration
@SpringBootApplication
//@EnableWebMvc
@MapperScan(basePackages={"com.framework.common.base"})
public class CommonApplication extends WebMvcConfigurerAdapter  {
	
    public static void main(String[] args) {
    	SpringApplication.run(CommonApplication.class, args);
    }

}	

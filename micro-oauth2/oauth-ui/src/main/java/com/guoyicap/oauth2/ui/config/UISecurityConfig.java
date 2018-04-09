package com.guoyicap.oauth2.ui.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by wuyu on 2016/9/10.
 */
@Configuration
@EnableOAuth2Sso// 实现基于OAuth2的单点登录，建议跟踪进代码阅读以下该注解的注释，很有用
@Order(6)
public class UISecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/login")
                //antMatcher("/**")// 所有请求都得经过认证和授权
                .permitAll()
                .anyRequest()
                .authenticated();
    }

}

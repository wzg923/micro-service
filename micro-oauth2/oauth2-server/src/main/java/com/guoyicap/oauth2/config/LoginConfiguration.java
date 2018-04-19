package com.guoyicap.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.guoyicap.oauth2.service.UserServiceImpl;

/**
 * Created by wuyu on 2016/8/29.
 */
@Configuration
public class LoginConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserServiceImpl userCenterDetailsService;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.authorizeRequests()
				.antMatchers("/admin/**")
				.hasRole("ADMIN")
				.and()
				.csrf()
				.disable();
		http.httpBasic();
		http.requestMatchers()
				.antMatchers("/oauth/**")
				.and()
				.authorizeRequests()
				.antMatchers("/oauth/**")
				.authenticated();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userCenterDetailsService)
				// .passwordEncoder(new Md5PasswordEncoder());
				.passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	// 共享验证器 oauth2,Security
	// 不定义没有password grant_type
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}

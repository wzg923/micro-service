package com.guoyicap.micro.common.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Value("${spring.http.multipart.location}")
	private String multipartLocation;
	//@Autowired
	//private LoginInterceptor loginInterceptor;
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+multipartLocation+"/upload/");
        registry.addResourceHandler("/resoures/**").addResourceLocations("classpath:/resoures/");
    }
    
    
    @Override  
    public void addCorsMappings(CorsRegistry registry) {  
        registry.addMapping("/**")  
                .allowedOrigins("*")  
                .allowCredentials(true)  
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")  
               // .allowedHeaders("authKey","sessionId", "Content-Type")
                //.exposedHeaders("authKey", "sessionId")
                .maxAge(3600);  
    }  
    
    
   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/**")
//        .excludePathPatterns("/admin/login", "/admin/logout", "/admin/configs", "/admin/verify", "/static/**", "/upload/**", "/resoures/**", "swagger-resources/**","/v2/api-docs")
//        ;
        super.addInterceptors(registry);
    }


	/**
	 * 文件上传临时路径
	 *//*
	 @Bean
	 MultipartConfigElement multipartConfigElement() {
	    MultipartConfigFactory factory = new MultipartConfigFactory();
	    factory.setLocation("/src/main/resources");
	    return factory.createMultipartConfig();
	}*/
}



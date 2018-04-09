package com.guoyicap.oauth2.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wuyu on 2016/8/17.
 */
@Configuration
public class RestConfigruation {

    @Bean
    @ConditionalOnMissingBean
    public HttpClient httpClient() {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(2000)
                .setSocketTimeout(2000)
                .build();
        return HttpClientBuilder.create()
                .setConnectionManager(manager)
                .setDefaultRequestConfig(requestConfig)
                .setMaxConnPerRoute(200)
                .setMaxConnTotal(200)
                .build();
    }


    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate(HttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.getMessageConverters().add(0, new FastJsonHttpMessageConverter4());
        return restTemplate;
    }}

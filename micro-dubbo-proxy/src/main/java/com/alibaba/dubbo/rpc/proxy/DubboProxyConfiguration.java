package com.alibaba.dubbo.rpc.proxy;

import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wuyu on 2016/7/8.
 */
@Configuration
public class DubboProxyConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AnnotationBean annotationBean() {
        return new AnnotationBean();
    }

    @Bean
    @ConditionalOnMissingBean
    public DubboGenericRestProxy dubboGenericRestProxy() {
        return new DubboGenericRestProxy();
    }

}

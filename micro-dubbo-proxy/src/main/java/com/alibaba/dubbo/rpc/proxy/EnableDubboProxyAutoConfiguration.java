package com.alibaba.dubbo.rpc.proxy;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by wuyu on 2016/7/8.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DubboProxyConfiguration.class})
public @interface EnableDubboProxyAutoConfiguration {
}

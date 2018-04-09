package com.alibaba.dubbo.rpc.proxy;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wuyu on 2016/7/7.
 * <p>
 * dubbo服务代理,转换Rest服务.
 */
@RestController
public class DubboGenericRestProxy implements ApplicationContextAware, DisposableBean {

    private Map<String, GenericService> genericServiceMap = new ConcurrentHashMap<String, GenericService>();

    @Autowired
    private ApplicationConfig requestApplicationConfig;

    @Autowired
    private RegistryConfig requestRegistryConfig;

    @Autowired(required = false)
    private ConsumerConfig consumerConfig;

    private ApplicationContext applicationContext;

    @RequestMapping(value = "/{group}/{version}/{service}/{method}", method = RequestMethod.POST)
    public Object proxy(@PathVariable("group") String group,
                        @PathVariable("version") String version,
                        @PathVariable("service") String service,
                        @PathVariable("method") String method,
                        //list是为了让参数有序传递,  key 为参数类型,value 为参数值
                        @RequestBody List<Map<String, Object>> body) {
        GenericServiceConfig config = new GenericServiceConfig();
        config.setGroup(group);
        config.setVersion(version);
        config.setService(service);
        config.setMethod(method);

        String[] argsType = new String[body.size()];
        Object[] args = new Object[body.size()];
        for (int i = 0; i < body.size(); i++) {
            String key = body.get(i).keySet().iterator().next();
            argsType[i] = key;
            args[i] = body.get(i).get(key);
        }

        config.setArgs(args);
        config.setArgsType(argsType);
        return genericService(config).$invoke(method, argsType, args);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object proxyRoot(@RequestBody GenericServiceConfig config) {
        return genericService(config).$invoke(config.getMethod(), config.getArgsType(), config.getArgs());
    }


    @RequestMapping(value = "/{group}/{version}/{service}/{method}", method = RequestMethod.POST, headers = "argsType")
    public Object proxyHeader(@PathVariable("group") String group,
                              @PathVariable("version") String version,
                              @PathVariable("service") String service,
                              @PathVariable("method") String method,
                              //请求头传递,参数类型.逗号分隔
                              @RequestHeader(name = "argsType", required = false) String[] argsType,
                              @RequestBody Object[] args) {
        GenericServiceConfig config = new GenericServiceConfig();
        config.setGroup(group);
        config.setVersion(version);
        config.setService(service);
        config.setMethod(method);
        config.setArgs(args);
        config.setArgsType(argsType);
        return genericService(config).$invoke(method, argsType, args);
    }


    public GenericService genericService(GenericServiceConfig config) {
        String key = sliceKey(config);
        GenericService genericService = genericServiceMap.get(key);
        if (genericService != null) {
            return genericService;
        }
        ReferenceBean<GenericService> reference = new ReferenceBean<GenericService>(); // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        reference.setApplicationContext(applicationContext);
        reference.setInterface(config.getService()); // 弱类型接口名
        if (!config.getVersion().equals("0.0.0")) {
            reference.setVersion(config.getVersion());
        }
        if (!config.getGroup().equalsIgnoreCase("defaultGroup")) {
            reference.setGroup(config.getGroup());
        }
        reference.setConsumer(consumerConfig);
        reference.setApplication(requestApplicationConfig);
        reference.setRegistry(requestRegistryConfig);
        reference.setGeneric(true); // 声明为泛化接口
        genericService = reference.get();
        genericServiceMap.put(key, genericService);
        return genericService; // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
    }

    private String sliceKey(GenericServiceConfig config) {
        return "/" + config.getGroup() + "/" + config.getVersion() + "/" + config.getService();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void destroy() throws Exception {
        genericServiceMap.clear();
        applicationContext = null;
    }
}

package com.guoyicap.micro.config.user.ui;

import com.guoyicap.micro.config.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuyu on 2016/7/6.
 */
@RestController
@RequestMapping(value = "/dubboProxy")
public class UserController {


    @Autowired
    @Qualifier("restTemplate")
    RestTemplate restTemplate;

    @Autowired
    @Qualifier("loadBalancedRestTemplate")
    RestTemplate loadBalancedRestTemplate;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User selectByPrimaryKey(@PathVariable("id") Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Map<String,Object> map=new HashMap<>();
        map.put(id.getClass().getName(),id);
        HttpEntity<List> httpEntity = new HttpEntity<List>(Arrays.asList(map), headers);
        //同样也可以使用eureka application name  进行访问 dubbo-rpc-proxy,可以不使用localhost直接访问
        return restTemplate.postForObject("http://localhost:10001/defaultGroup/0.0.0/UserService/selectByPrimaryKey/",httpEntity,User.class);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Map<String,Object> map=new HashMap<>();
        map.put(id.getClass().getName(),id);
        HttpEntity<List> httpEntity = new HttpEntity<List>(Arrays.asList(map), headers);
        //可以不使用localhost直接访问,可以使用eureka服务发现  application name  进行访问 dubbo-rpc-proxy,
        return restTemplate.postForObject("http://localhost:10001/defaultGroup/0.0.0/UserService/deleteByPrimaryKey/",httpEntity,String.class);
    }


    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String insert(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //请求头携带参数类型,多个参数以逗号分隔
        headers.add("argsType",user.getClass().getName());
        Map<String,Object> map=new HashMap<>();
        HttpEntity<List> httpEntity = new HttpEntity<List>(Arrays.asList(map), headers);
        //可以不使用localhost直接访问,可以使用eureka服务发现  application name  进行访问 dubbo-rpc-proxy,
        return loadBalancedRestTemplate.postForObject("http://dubbo-rpc-proxy/defaultGroup/0.0.0/UserService/insert/",httpEntity,String.class);
    }
}

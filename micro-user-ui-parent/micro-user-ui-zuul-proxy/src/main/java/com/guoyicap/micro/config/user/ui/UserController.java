package com.guoyicap.micro.config.user.ui;

import com.guoyicap.micro.config.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wuyu on 2016/7/5.
 */
@RestController
@RequestMapping("/zuulProxy")
public class UserController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User selectByPrimaryKey(@PathVariable("id") Integer id) {
        //调用zuul代理服务 http://代理地址:端口/服务的应用名/服务
        //代理地址可以用 应用名代替,前提是开启@EnableEurekaClient
        //restTemplate.getForObject("http://zuul-server/micro-user/user/" + id, User.class);
        return restTemplate.getForObject("http://localhost:10000/micro-user/user/" + id, User.class);
    }



}

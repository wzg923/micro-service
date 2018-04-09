package com.guoyicap.micro.config.user.ui;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.guoyicap.micro.config.user.model.User;
import com.guoyicap.micro.config.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wuyu on 2016/7/6.
 */
@RestController
@RequestMapping("/feign")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User selectByPrimaryKey(@PathVariable("id") Integer id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return userService.list();
    }


    @RequestMapping(value = "/mockfallback",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallback")
    public String mockfallback(){
        int i = 1/0;
        return String.valueOf(i);
    }

    public String fallback(){
        return "服务器错误!";
    }
}

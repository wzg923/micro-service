package com.guoyicap.micro.config.user.ui;

import com.guoyicap.micro.config.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wuyu on 2016/7/5.
 */
@RestController
@RequestMapping("/ribbon")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Tracer tracer;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User selectByPrimaryKey(@PathVariable("id") Integer id) {
        tracer.addTag("key","访问了方法");
        return restTemplate.getForObject("http://micro-user/user/" + id, User.class);
    }

}

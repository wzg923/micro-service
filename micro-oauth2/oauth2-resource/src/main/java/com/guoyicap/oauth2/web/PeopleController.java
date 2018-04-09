package com.guoyicap.oauth2.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuyu on 2016/9/10.
 */
@RestController
@RequestMapping("/resource")
public class PeopleController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}

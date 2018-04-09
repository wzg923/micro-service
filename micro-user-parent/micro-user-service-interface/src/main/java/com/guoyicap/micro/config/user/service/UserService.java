package com.guoyicap.micro.config.user.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.guoyicap.micro.config.user.model.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * Created on 2016/7/05 11:44.
 */
@FeignClient(serviceId = "micro-user")
public interface UserService {

    @ApiOperation(value = "根据主键id获取对象!",notes = "这个方法的主要作用是通过id获取对象,例子; http://localhost:8080/user/1",httpMethod = "GET", response = User.class)
    //@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping(value="/user/{id}")
    User selectByPrimaryKey(
            @ApiParam(name = "id", value = "用户id", required = true, example = "http://localhost/user/1")
            @PathVariable("id") Integer id);

    @ApiOperation(value = "获取所有User对象", httpMethod = "GET", response = List.class)
    //@RequestMapping(value = "/user/list", method = RequestMethod.GET)
    @GetMapping(value="/user/list")
    List<User> list();

    @ApiOperation(value = "根据主键删除对象", httpMethod = "DELETE", response = Integer.class)
    //@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @DeleteMapping(value="/user/{id}")
    int deleteByPrimaryKey(@PathVariable("id") Integer id);

    @ApiOperation(value = "插入对象", httpMethod = "POST", response = Integer.class,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    //@RequestMapping(value = "/user",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    int insert(@RequestBody User user);

    //@RequestMapping(value = "/user",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据主键删除对象", httpMethod = "PUT", response = Integer.class)
    int updateByPrimaryKey(@RequestBody User user);


    @ApiOperation(value = "分页获取User对象", httpMethod = "POST", response = PageInfo.class)
    //@RequestMapping(value = "/user/pageList", method = RequestMethod.POST)
    @PostMapping(value = "/user/pageList")
    PageInfo<User> getPageList(@RequestBody User user);

}
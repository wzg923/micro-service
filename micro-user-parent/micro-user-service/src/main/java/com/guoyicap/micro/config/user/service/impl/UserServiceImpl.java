package com.guoyicap.micro.config.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Service;
//import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.guoyicap.micro.common.util.BeanUtils;
import com.guoyicap.micro.config.user.domain.UserServiceDomain;
import com.guoyicap.micro.config.user.entity.TSUser;
import com.guoyicap.micro.config.user.model.User;
import com.guoyicap.micro.config.user.service.UserService;

/**
 * Created on 2016/7/05 11:44.
 */
@Service(version = "1.0.0", application = "${dubbo.application.id}", protocol = "${dubbo.protocol.id}", registry = "${dubbo.registry.id}")
@RestController
public class UserServiceImpl implements UserService {

	// @Autowired
	// private UserDao userDao;
	@Autowired
	private UserServiceDomain userServiceDomain;

	@Override
	public User selectByPrimaryKey(@PathVariable("id") String id) {
		return userServiceDomain.selectByPrimaryKey(id);
	}

	@Override
	public User selectByUsername(String username) {
		TSUser record = new TSUser();
		record.setUsername(username);
		TSUser tsUser = (TSUser) userServiceDomain.selectOne(record);
		User user = new User();
		BeanUtils.toJavaBean(user, tsUser);
		return user;
	}

	@Override
	public List<User> list() {
		return userServiceDomain.list();
	}

	@Override
	public int insert(@RequestBody User user) {
		return userServiceDomain.insert(user);
	}

	@Override
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		return userServiceDomain.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(@RequestBody User user) {
		return userServiceDomain.updateByPrimaryKey(user);
	}

	@Override
	public PageInfo<User> getPageList(@RequestBody User user) {
		TSUser record = new TSUser();
		BeanUtils.toJavaBean(record, user);
		return userServiceDomain.getDataList(record);
	}

}
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
import com.guoyicap.micro.config.user.dao.UserDao;
import com.guoyicap.micro.config.user.domain.SysAdminUserService;
import com.guoyicap.micro.config.user.entity.SysAdminUser;
import com.guoyicap.micro.config.user.model.User;
import com.guoyicap.micro.config.user.service.UserService;

/**
 * Created on 2016/7/05 11:44.
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private SysAdminUserService sysAdminUserService;
    
    
    @Override
    public User selectByPrimaryKey(@PathVariable("id") Integer id) {
        return userDao.selectByPrimaryKey(id);
    }
    @Override
    public List<User> list() {
        return userDao.list();
    }
    @Override
    public int insert(@RequestBody User user) {
        return userDao.insert(user);
    }
    @Override
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }
    @Override
    public int updateByPrimaryKey(@RequestBody User user) {
        return userDao.updateByPrimaryKey(user);
    }

	@Override
	public PageInfo<User> getPageList(@RequestBody User user) {
		SysAdminUser record=new SysAdminUser();
		BeanUtils.toJavaBean(record, user);
		return sysAdminUserService.getDataList(record);
	}


}
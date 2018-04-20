package com.guoyicap.micro.config.user.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.guoyicap.micro.common.base.BaseServiceImpl2;
import com.guoyicap.micro.config.user.dao.TSUserDao;
import com.guoyicap.micro.config.user.dao.UserDao;
import com.guoyicap.micro.config.user.entity.TSBaseUser;
import com.guoyicap.micro.config.user.model.User;

import tk.mybatis.mapper.common.Mapper;

@Service
@Transactional
public class UserServiceDomain extends BaseServiceImpl2<TSBaseUser> {
	/*
	 * public UserServiceDomain(Validator validator) { super(validator); }
	 */

	@Autowired
	private UserDao userDao;

	@Autowired
	private TSUserDao tsUserDao;

	@Override
	public Mapper getMapper() {
		return tsUserDao;
	}

	public PageInfo<TSBaseUser> getDataList(TSBaseUser record) {
		PageInfo<TSBaseUser> pageInfo = super.selectPage(record.getPage(), record.getRows(), record);
		return pageInfo;
	}

	public User selectByPrimaryKey(String id) {
		return userDao.selectByPrimaryKey(id);
	}

	public List<User> list() {
		return userDao.list();
	}

	public int deleteByPrimaryKey(String id) {
		return tsUserDao.deleteByPrimaryKey(id);
	}

	public int insert(User user) {
		return userDao.insert(user);
	}

	public int updateByPrimaryKey(User user) {
		return userDao.updateByPrimaryKey(user);
	}

}

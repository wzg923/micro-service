package com.guoyicap.micro.config.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.guoyicap.micro.common.base.BaseServiceImpl;
import com.guoyicap.micro.config.user.dao.SysAdminUserDao;
import com.guoyicap.micro.config.user.entity.SysAdminUser;
import com.guoyicap.micro.config.user.model.User;

import tk.mybatis.mapper.common.Mapper;

@Service
public class SysAdminUserService extends BaseServiceImpl{
	@Autowired
	private SysAdminUserDao sysAdminUserDao;
	
	@Override
	public Mapper getMapper() {
		return sysAdminUserDao;
	}
	
	
	public PageInfo<User> getDataList(SysAdminUser record){
		return super.selectPage(record.getPage(), record.getRows(), record);
	}




	

}

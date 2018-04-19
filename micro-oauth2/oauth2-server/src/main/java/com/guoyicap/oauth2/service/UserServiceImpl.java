/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.guoyicap.oauth2.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.guoyicap.micro.common.base.BaseServiceImpl;
import com.guoyicap.micro.common.util.BeanUtils;
import com.guoyicap.oauth2.dao.UserDao;
import com.guoyicap.oauth2.entity.TSUser;
import com.guoyicap.oauth2.exception.AuthenticationException;
import com.guoyicap.oauth2.exception.DuplicateUserException;
import com.guoyicap.oauth2.model.Authority;
import com.guoyicap.oauth2.model.Role;
import com.guoyicap.oauth2.model.User;
import com.guoyicap.oauth2.model.api.ApiUser;

import tk.mybatis.mapper.common.Mapper;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService, UserDetailsService {

	private Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder; // spring security md5
	// PasswordEncoder passwordEncoder =
	// PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 模拟用户,具体可以从数据库中检索相关用户
		// String userId = "1";
		// 123456
		// String password = "e10adc3949ba59abbe56e057f20f883e";
		// String image =
		// "http://pic.shijue.me/picurl/avatar/5992fa65e4c30962c37a8e712bfa96027_d_1472712276754---jpg.jpg?code=de3cd0732028b6a6";
		// String nickName = "Monkey";
		// 用户所具备的权限, 具体权限可以从表中检索
		// List<SimpleGrantedAuthority> roleUser = Collections.singletonList(new
		// SimpleGrantedAuthority("ROLE_USER"));
		Assert.notNull(username, "参数非法:username is null");
		String password = passwordEncoder.encode("111111");

		TSUser tsuser = userDao.getUserByUsername(username);
		System.err.println(tsuser.getUsername());
		Set<Role> roles = userDao.selectRoleByUserId(username);
		Set<GrantedAuthority> userAuthotities = new HashSet<>();
		for (Role role : roles) {
			Set<Authority> authorities = userDao.selectAuthorityByRoleId(role.getId());

			for (Authority authority : authorities) {
				userAuthotities.add(new SimpleGrantedAuthority(authority.getValue()));
			}
		}

		return new User(tsuser.getUsername(), tsuser.getPassword(), userAuthotities, tsuser.getId(), tsuser.getNickName(),
				"https://www.fengniaocaifu.com/fn/plug-in/static/images/public/user.png");
	}

	@Override
	public ApiUser createUser(User createUserRequest) {
		LOG.info("Validating user request.");
		validate(createUserRequest);
		// final String emailAddress = createUserRequest.getEmail().toLowerCase();
		final String username = createUserRequest.getUsername().toLowerCase();
		TSUser record = new TSUser();
		record.setUsername(username);
		if (userDao.selectOne(record) == null) {
			LOG.info("User does not already exist in the data store - creating a new user [{}].", username);
			BeanUtils.toJavaBean(record, createUserRequest);
			int i = userDao.insertSelective(record);
			LOG.debug("Created new user [{}].", record.getUsername());

			ApiUser apiUser = new ApiUser();
			BeanUtils.toJavaBean(apiUser, record);
			return apiUser;
		} else {
			LOG.info("Duplicate user located, exception raised with appropriate HTTP response code.");
			throw new DuplicateUserException();
		}
	}

	@Override
	public ApiUser authenticate(String username, String password) {
		Assert.notNull(username);
		Assert.notNull(password);
		TSUser tsuser = userDao.getUserByUsername(username);
		if (!passwordEncoder.encode(password).equals(tsuser.getPassword())) {
			throw new AuthenticationException();
		}
		ApiUser apiUser = new ApiUser();
		BeanUtils.toJavaBean(apiUser, tsuser);
		return apiUser;
	}

	@Override
	public ApiUser getUser(String userId) {
		TSUser tsUser = userDao.selectByPrimaryKey(userId);
		ApiUser apiUser = new ApiUser();
		BeanUtils.toJavaBean(apiUser, tsUser);
		return apiUser;
	}

	@Override
	public ApiUser saveUser(User request) {
		validate(request);
		TSUser tsUser = userDao.selectByPrimaryKey(request.getId());
		if (tsUser == null) {
			TSUser record = new TSUser();
			record.setUsername(request.getUsername());
			tsUser = userDao.selectOne(record);
		}
		ApiUser apiUser = new ApiUser();
		if (tsUser == null) {
			TSUser record = new TSUser();
			BeanUtils.toJavaBean(record, request);
			int i = userDao.insertSelective(record);
			BeanUtils.toJavaBean(apiUser, record);
		} else {
			BeanUtils.toJavaBean(tsUser, request);
			int i = userDao.updateByPrimaryKey(tsUser);
			BeanUtils.toJavaBean(apiUser, tsUser);
		}

		return apiUser;
	}

	@Override
	public Mapper getMapper() {
		return userDao;
	}

}

package com.guoyicap.micro.config.user.dao;

import java.util.List;

import com.guoyicap.micro.config.user.model.User;

/**
 * Created on 2016/7/05 11:44.
 */
public interface UserDao {

    public User selectByPrimaryKey(String id);
    
    public List<User> list();

    public int deleteByPrimaryKey(String id);

    public int insert(User user);

    public int updateByPrimaryKey(User user);
}
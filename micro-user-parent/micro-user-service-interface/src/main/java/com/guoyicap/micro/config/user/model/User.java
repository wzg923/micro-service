package com.guoyicap.micro.config.user.model;

import java.io.Serializable;

import com.guoyicap.micro.common.base.BaseModel;

/**
 * Created on 2016/7/05 11:44.
 * 
 * id 	INTEGER 	10 	
 * username 	VARCHAR 	32 	
 * password 	VARCHAR 	32 	
 */

public class User extends BaseModel implements Serializable {
    private static final long serialVersionUID = 6985965045661480463L;

    private Integer id;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username == null ? null : username.trim();
		return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password == null ? null : password.trim();
		return this;
    }
}

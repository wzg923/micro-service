package com.guoyicap.micro.config.user.model;

import java.io.Serializable;
import java.util.Set;

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

    private String id;

    private String username;

    private String password;
    
    private Set<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}

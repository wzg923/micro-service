package com.guoyicap.oauth2.model.api;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by wuyu on 2016/8/29.
 */
public class ApiUser {

	private String id;
	
	private String username;
	
    private String openId;

    private String nickName;
    
    private String realname;

    private String image;
    
    private String email;
    
    private String mobilePhone;

    public String getImage() {
        return image;
    }

    public ApiUser setImage(String image) {
        this.image = image;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public ApiUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public ApiUser setOpenId(String openId) {
        this.openId = openId;
        return this;
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobilePhone() {
		return mobilePhone;
	}


	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}

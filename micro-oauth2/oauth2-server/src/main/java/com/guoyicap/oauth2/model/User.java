package com.guoyicap.oauth2.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by wuyu on 2016/8/29.
 */
public class User extends org.springframework.security.core.userdetails.User{

	private String id;
	
    private String openId;

    private String nickName;
    
    private String realname;

    private String image;
    
    private String email;
    
    private String mobilePhone;

    
    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


    public User(String username, String password, Collection<? extends GrantedAuthority> authorities, String userId, String nickName, String image) {
        super(username, password, authorities);
        this.setImage(image)
                .setOpenId(userId)
                .setNickName(nickName);
    }


    public String getImage() {
        return image;
    }

    public User setImage(String image) {
        this.image = image;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public User setOpenId(String openId) {
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
	
	
}

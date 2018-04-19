package com.guoyicap.oauth2.model;

import java.util.Set;

/**
 * 角色表
 *  @author  张代浩
 */
public class Role implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6191653153436211100L;
	private String id;
	private String rolename;//角色名称
	private String rolecode;//角色编码
	private Set<Authority> authorities;	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRolecode() {
		return rolecode;
	}
	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	
	
}
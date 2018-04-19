package com.guoyicap.micro.config.user.model;

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
	private String roleName;//角色名称
	private String roleCode;//角色编码
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	
	
}
package com.guoyicap.micro.config.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.guoyicap.micro.common.base.IdEntity;

/**
 * 系统用户父类表
 * 
 * @author 张代浩
 */
@Entity
@Table(name = "t_s_base_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class TSBaseUser extends IdEntity implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String username;// 用户名
	private String realname;// 真实姓名
	private String browser;// 用户使用浏览器类型
	private String userkey;// 用户验证唯一标示
	private String password;// 用户密码
	private Short activitiSync;// 是否同步工作流引擎
	private Short status;// 状态1：启用,0：禁用
	private byte[] signature;// 签名文件
	private String deleteFlag = "0";// 删除标志 1：已删除, 0：未删除
	// private TSDepart TSDepart = new TSDepart();// 部门
	// private List<TSUserOrg> userOrgList = new ArrayList<TSUserOrg>();
	// private TSDepart currentDepart = new TSDepart();// 当前部门

	// private Integer id;

	@Column(name = "signature", length = 3000)
	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	@Column(name = "browser", length = 20)
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	@Column(name = "userkey", length = 200)
	public String getUserkey() {
		return userkey;
	}

	public void setUserkey(String userKey) {
		this.userkey = userKey;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getActivitiSync() {
		return activitiSync;
	}

	@Column(name = "activitisync")
	public void setActivitiSync(Short activitiSync) {
		this.activitiSync = activitiSync;
	}

	@Column(name = "password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// @JsonIgnore //getList查询转换为列表时处理json转换异常
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "departid")
	// public TSDepart getTSDepart() {
	// return this.TSDepart;
	// }
	//
	// public void setTSDepart(TSDepart TSDepart) {
	// this.TSDepart = TSDepart;
	// }
	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	@Column(name = "realname", length = 50)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realName) {
		this.realname = realName;
	}
	// @Transient
	// public TSDepart getCurrentDepart() {
	// return currentDepart;
	// }
	//
	// public void setCurrentDepart(TSDepart currentDepart) {
	// this.currentDepart = currentDepart;
	// }
	//
	// @JsonIgnore
	// @OneToMany(mappedBy = "tsUser")
	// public List<TSUserOrg> getUserOrgList() {
	// return userOrgList;
	// }
	//
	// public void setUserOrgList(List<TSUserOrg> userOrgList) {
	// this.userOrgList = userOrgList;
	// }

	@Column(name = "delete_flag", length = 1)
	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deleteFlag = deletedFlag;
	}

}
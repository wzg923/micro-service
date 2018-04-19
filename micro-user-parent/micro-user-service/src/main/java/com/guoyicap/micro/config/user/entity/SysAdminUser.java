package com.guoyicap.micro.config.user.entity;

import javax.persistence.Column;
import javax.persistence.Table;

import com.guoyicap.micro.common.base.BaseEntity;

@Table(name = "`t_s_base_user`")
public class SysAdminUser  extends BaseEntity {
	private static final long serialVersionUID = -6695722256864729383L;

    /**
     * 管理后台账号
     */
    @Column(name = "`username`")
    private String username;

    /**
     * 管理后台密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 用户备注
     */
   // @Column(name = "`remark`")
   // private String remark;

    //@Column(name = "`create_time`")
   // private Integer createTime;

    /**
     * 真实姓名
     */
    @Column(name = "`realname`")
    private String realname;

    /**
     * 部门
     */
   // @Column(name = "`structure_id`")
    //private Integer structureId;

    /**
     * 岗位
     */
    //@Column(name = "`post_id`")
   // private Integer postId;

    /**
     * 状态,1启用0禁用
     */
    //@Column(name = "`status`")
   // private Byte status;


    /**
     * 获取管理后台账号
     *
     * @return username - 管理后台账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置管理后台账号
     *
     * @param username 管理后台账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取管理后台密码
     *
     * @return password - 管理后台密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置管理后台密码
     *
     * @param password 管理后台密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

   
   


    /**
     * 获取真实姓名
     *
     * @return realname - 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实姓名
     *
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

  
}

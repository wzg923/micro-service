package com.guoyicap.oauth2.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Select;

import com.guoyicap.micro.common.base.MyMapper;
import com.guoyicap.oauth2.entity.TSUser;
import com.guoyicap.oauth2.model.Authority;
import com.guoyicap.oauth2.model.Role;

public interface UserDao extends  MyMapper<TSUser>{

	@Select("select bu.id,username,password,nick_name ,image,mobilePhone from t_s_base_user bu,t_s_user u where bu.id=u.id and username=#{username}")
	TSUser getUserByUsername(String username);
	
	@Select("select r.id,rolecode,rolename from t_s_role r,t_s_role_user ru,t_s_base_user u where r.id=ru.roleid and ru.userid=u.ID and u.username=#{username}")
	Set<Role> selectRoleByUserId(String username);
	
	@Select("SELECT a.id,value,name from sys_authority a,t_s_role_authority ra where a.id=ra.authority_id and ra.role_id=#{roleId}")
	Set<Authority> selectAuthorityByRoleId(String roleId);
}

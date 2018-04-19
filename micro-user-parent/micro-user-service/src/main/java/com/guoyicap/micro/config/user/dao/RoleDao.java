package com.guoyicap.micro.config.user.dao;

import org.apache.ibatis.annotations.Select;

import com.guoyicap.micro.common.base.MyMapper;
import com.guoyicap.micro.config.user.entity.TSRole;

/**
 * Created on 2016/7/05 11:44.
 */
public interface RoleDao extends  MyMapper<TSRole>{

    /*public TSRole selectByPrimaryKey(String id);
    
    public List<TSRole> list();

    public int deleteByPrimaryKey(String id);

    public int insert(TSRole role);

    public int updateByPrimaryKey(TSRole role);*/
    
    @Select("select * from t_s_role r,t_s_role_user ru,t_s_base_user u where r.id=ru.roleid and ru.userid=u.ID and u.username=#{username}")
    public TSRole selectRoleByUser(String username);
}
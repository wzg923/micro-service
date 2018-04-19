package com.guoyicap.micro.config.user.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.guoyicap.micro.common.base.IdEntity;

/**
 * 角色-组织机构 实体
 * <p/>
 * <p><b>User:</b> zhanggm <a href="mailto:guomingzhang2008@gmail.com">guomingzhang2008@gmail.com</a></p>
 * <p><b>Date:</b> 2014-08-21 13:48</p>
 *
 * @author 张国明
 */
@Entity
@Table(name = "t_s_role_org")
public class TSRoleOrg extends IdEntity implements java.io.Serializable {
    private TSDepart tsDepart;
    private TSRole tsRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "org_id")
    public TSDepart getTsDepart() {
        return tsDepart;
    }

    public void setTsDepart(TSDepart tsDepart) {
        this.tsDepart = tsDepart;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    public TSRole getTsRole() {
        return tsRole;
    }

    public void setTsRole(TSRole tsRole) {
        this.tsRole = tsRole;
    }
}

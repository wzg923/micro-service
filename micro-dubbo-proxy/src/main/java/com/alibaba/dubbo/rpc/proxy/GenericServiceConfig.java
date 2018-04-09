package com.alibaba.dubbo.rpc.proxy;

import com.alibaba.dubbo.common.utils.StringUtils;

import java.io.Serializable;

/**
 * Created by wuyu on 2016/7/7.
 */
public class GenericServiceConfig implements Serializable {

    private static final long serialVersionUID = 1064223171940612201L;

    //服务名
    private String service;

    //方法
    private String method;

    //组名
    private String group;

    //版本
    private String version;

    //参数类型
    private String[] argsType;

    //参数
    private Object[] args;

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String[] getArgsType() {
        return argsType;
    }

    public void setArgsType(String[] argsType) {
        this.argsType = argsType;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        if (StringUtils.isBlank(group)) {
            return;
        }
        this.group = group;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        if (StringUtils.isBlank(version)) {
            return;
        }
        this.version = version;
    }

    public GenericServiceConfig() {
    }


}

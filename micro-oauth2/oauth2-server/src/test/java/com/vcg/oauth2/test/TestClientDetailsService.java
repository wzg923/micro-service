package com.vcg.oauth2.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.provider.approval.Approval;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by wuyu on 2016/8/30.
 */
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TestClientDetailsService {

    @Autowired
    JdbcClientDetailsService jdbcClientDetailsService;

    @Autowired
    JdbcApprovalStore jdbcApprovalStore;

    /**
     * 客户端必须得到用户的授权（authorization grant），才能获得令牌（access token）。OAuth 2.0定义了四种授权方式。
     * <p>
     * 1. 授权码模式（authorization code）
     * 2. 简化模式（implicit）
     * 3. 密码模式（resource owner password credentials）
     * 4. 客户端模式（client credentials）
     *
     * 对外可以提供
     * 1. 授权码模式（authorization code）
     * 2. 简化模式（implicit）
     *
     * 对内可开启
     * 3. 密码模式（resource owner password credentials）
     * 4. 客户端模式（client credentials）
     * </>
     */
    @Test
    public void testAddClientDetails() {
        //
        BaseClientDetails clientDetails = new BaseClientDetails("acme", null, "openid", "authorization_code,implicit,refresh_token,password,client_credentials", "USER,ADMIN");
        clientDetails.setClientSecret("acmesecret");
        jdbcClientDetailsService.addClientDetails(clientDetails);
        jdbcClientDetailsService.removeClientDetails("test");
    }

    @Test
    public void testApprovalStore(){
        List<Approval> acme = jdbcApprovalStore.getApprovals("18518459905", "acme");
    }

}
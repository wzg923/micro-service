package com.guoyicap.oauth2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

//see http://www.ruanyifeng.com/blog/2014/05/oauth_2_0.html

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

/**
 * password 方式授权,无需网页跳转
 * <p>
 * curl -X POST -vu acme:acmesecret http://localhost:8080/oauth/token -H "Accept: application/json"
 * -d "password=spring&username=roy&grant_type=password&scope=openid&client_secret=123456&client_id=clientapp"
 * curl http://localhost:8080/greeting -H "Authorization: Bearer ff16372e-38a7-4e29-88c2-1fb92897f558"
 * <p>
 * code方式授权 需网页跳转
 * http://localhost/oauth/authorize?client_id=acme&redirect_uri=http://localhost:9999/dashboard/login&response_type=code&state=f7SISS
 * <p>
 * <p>
 * <p>
 * curl -X POST -vu acme:acmesecret http://localhost/oauth/token -H "Accept: application/json"
 * -d "grant_type=authorization_code&scope=openid&client_secret=acmesecret&client_id=acme&code=e8fc2k&redirect_uri=http://localhost:9999/dashboard/login"
 * <p>
 * code方式授权 需网页跳转
 * http://localhost/oauth/authorize?client_id=acme&redirect_uri=http://localhost:9999/dashboard/login&response_type=code&state=f7SISS
 * <p>
 * <p>
 * <p>
 * curl -X POST -vu acme:acmesecret http://localhost/oauth/token -H "Accept: application/json"
 * -d "grant_type=authorization_code&scope=openid&client_secret=acmesecret&client_id=acme&code=e8fc2k&redirect_uri=http://localhost:9999/dashboard/login"
 * <p>
 * code方式授权 需网页跳转
 * http://localhost/oauth/authorize?client_id=acme&redirect_uri=http://localhost:9999/dashboard/login&response_type=code&state=f7SISS
 * <p>
 * <p>
 * <p>
 * curl -X POST -vu acme:acmesecret http://localhost/oauth/token -H "Accept: application/json"
 * -d "grant_type=authorization_code&scope=openid&client_secret=acmesecret&client_id=acme&code=e8fc2k&redirect_uri=http://localhost:9999/dashboard/login"
 */

/**
 * code方式授权 需网页跳转
 * http://localhost/oauth/authorize?client_id=acme&redirect_uri=http://localhost:9999/dashboard/login&response_type=code&state=f7SISS
 *
 *
 *
 * curl -X POST -vu acme:acmesecret http://localhost/oauth/token -H "Accept: application/json"
 * -d "grant_type=authorization_code&scope=openid&client_secret=acmesecret&client_id=acme&code=e8fc2k&redirect_uri=http://localhost:9999/dashboard/login"
 */

/**
 * implicit 简化方式,授权成功后会直接返回access_token
 * http://localhost/oauth/authorize?client_id=acme&redirect_uri=http://localhost:9999/dashboard/login&response_type=token&state=f7SISS
 *
 */
// 提供/oauth/authorize,/oauth/token,/oauth/check_token,/oauth/confirm_access,/oauth/error
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfigruation extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcApprovalStore jdbcApprovalStore;
	/**
	 * 注入authenticationManager 来支持 password grant type
	 */
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService)// 若无，refresh_token会有UserDetailsService  is required错误
				.tokenStore(this.tokenStore)
				.approvalStore(jdbcApprovalStore)
				.tokenServices(tokenServices());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource);
		clients.withClientDetails(jdbcClientDetailsService(dataSource));
		/*clients.inMemory()
	        .withClient("android")
	        .scopes("xx")
	        .secret("android")
	        .authorizedGrantTypes("password", "authorization_code", "refresh_token")
	        .and()
	        .withClient("webapp")
	        .scopes("xx")
	        .authorizedGrantTypes("implicit");*/
	}

	@Bean
	// 用户授权存储
	public JdbcApprovalStore jdbcApprovalStore() {
		return new JdbcApprovalStore(dataSource);
	}

	@Bean
	@Primary
	// 管理token,可以对token进行增删改查
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setTokenStore(this.tokenStore);
		// token有效期 30天
		tokenServices.setAccessTokenValiditySeconds(30 * 24 * 60 * 60);
		return tokenServices;
	}
	
	// client_details 授权 client_id,client_secret
	@Bean	
	public ClientDetailsService jdbcClientDetailsService(DataSource dataSource) {
		return new JdbcClientDetailsService(dataSource);
	}

	
	// token默认存储位置
	// jdbc,memory,redis
	@Bean
	public TokenStore getRedisTokenStore(RedisConnectionFactory redisConnectionFactory) {
		return new RedisTokenStore(redisConnectionFactory);//redis 存储token
	}
	
	// 初始化JdbcTokenStore
	/*@Bean
	public TokenStore getJdbcTokenStore(DataSource dataSource) {
		return new JdbcTokenStore(dataSource);
	}*/


	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()") // url:/oauth/token_key,exposes public key for token verification if
													// using JWT tokens
				.checkTokenAccess("isAuthenticated()") // url:/oauth/check_token allow check token
				.allowFormAuthenticationForClients();
	}
}

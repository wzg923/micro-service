
create table oauth_access_token (
  create_time timestamp default systimestamp,
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
) ;  
COMMENT ON COLUMN oauth_access_token.token_id IS 'MD5加密的access_token的值';  
COMMENT ON COLUMN oauth_access_token.token IS 'OAuth2AccessToken.java对象序列化后的二进制数据';  
COMMENT ON COLUMN oauth_access_token.authentication_id IS 'MD5加密过的username,client_id,scope';  
COMMENT ON COLUMN oauth_access_token.user_name IS '登录的用户名';  
COMMENT ON COLUMN oauth_access_token.client_id IS '客户端ID';  
COMMENT ON COLUMN oauth_access_token.authentication IS 'OAuth2Authentication.java对象序列化后的二进制数据';  
COMMENT ON COLUMN oauth_access_token.refresh_token IS 'MD5加密果的refresh_token的值';  
  
CREATE TABLE oauth_client_details  
(  
  client_id VARCHAR(255)   PRIMARY KEY, -- 客户端ID  
  resource_ids VARCHAR(255), -- 资源ID集合,多个资源时用逗号(,)分隔  
  client_secret VARCHAR(255), -- 客户端密匙  
  scope VARCHAR(255), -- 客户端申请的权限范围  
  authorized_grant_types VARCHAR(255), -- 客户端支持的grant_type  
  web_server_redirect_uri VARCHAR(255), -- 重定向URI  
  authorities VARCHAR(255), -- 客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔  
  access_token_validity integer, -- 访问令牌有效时间值(单位:秒)  
  refresh_token_validity integer, -- 更新令牌有效时间值(单位:秒)  
  additional_information VARCHAR(255), -- 预留字段  
  autoapprove VARCHAR(255)-- 用户是否自动Approval操作  
);  

COMMENT ON COLUMN oauth_client_details.client_id IS '客户端ID';  
COMMENT ON COLUMN oauth_client_details.resource_ids IS '资源ID集合,多个资源时用逗号(,)分隔';  
COMMENT ON COLUMN oauth_client_details.client_secret IS '客户端密匙';  
COMMENT ON COLUMN oauth_client_details.scope IS '客户端申请的权限范围';  
COMMENT ON COLUMN oauth_client_details.authorized_grant_types IS '客户端支持的grant_type';  
COMMENT ON COLUMN oauth_client_details.web_server_redirect_uri IS '重定向URI';  
COMMENT ON COLUMN oauth_client_details.authorities IS '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔';  
COMMENT ON COLUMN oauth_client_details.access_token_validity IS '访问令牌有效时间值(单位:秒)';  
COMMENT ON COLUMN oauth_client_details.refresh_token_validity IS '更新令牌有效时间值(单位:秒)';  
COMMENT ON COLUMN oauth_client_details.additional_information IS '预留字段';  
COMMENT ON COLUMN oauth_client_details.autoapprove IS '用户是否自动Approval操作'; 
 
create table oauth_refresh_token (
  create_time timestamp default systimestamp,
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
)  ;
COMMENT ON COLUMN oauth_refresh_token.token_id IS 'MD5加密过的refresh_token的值';  
COMMENT ON COLUMN oauth_refresh_token.token IS 'OAuth2RefreshToken.java对象序列化后的二进制数据';  
COMMENT ON COLUMN oauth_refresh_token.authentication IS 'OAuth2Authentication.java对象序列化后的二进制数据';  

CREATE TABLE oauth_client_token  
(  
  token_id varchar2(256), -- MD5加密的access_token值  
  token blob, -- OAuth2AccessToken.java对象序列化后的二进制数据  
  authentication_id  varchar2(256), -- MD5加密过的username,client_id,scope  
  user_name  varchar2(256), -- 登录的用户名  
  client_id  varchar2(256)-- 客户端ID  
);  
COMMENT ON COLUMN oauth_client_token.token_id IS 'MD5加密的access_token值';  
COMMENT ON COLUMN oauth_client_token.token IS 'OAuth2AccessToken.java对象序列化后的二进制数据';  
COMMENT ON COLUMN oauth_client_token.authentication_id IS 'MD5加密过的username,client_id,scope';  
COMMENT ON COLUMN oauth_client_token.user_name IS '登录的用户名';  
COMMENT ON COLUMN oauth_client_token.client_id IS '客户端ID';  
  
CREATE TABLE oauth_code  
(  
  code  varchar2(256), -- 授权码(未加密)  
  authentication blob -- AuthorizationRequestHolder.java对象序列化后的二进制数据  
);  
COMMENT ON COLUMN oauth_code.code IS '授权码(未加密)';  
COMMENT ON COLUMN oauth_code.authentication IS 'AuthorizationRequestHolder.java对象序列化后的二进制数据';  

CREATE TABLE oauth_approvals  
(  
  userid character varying(256), -- 登录的用户名  
  clientid character varying(256), -- 客户端ID  
  scope character varying(256), -- 申请的权限  
  status character varying(10), -- 状态（Approve或Deny）  
  expiresat timestamp  , -- 过期时间  
  lastmodifiedat timestamp   -- 最终修改时间  
);  
COMMENT ON COLUMN oauth_approvals.userid IS '登录的用户名';  
COMMENT ON COLUMN oauth_approvals.clientid IS '客户端ID';  
COMMENT ON COLUMN oauth_approvals.scope IS '申请的权限';  
COMMENT ON COLUMN oauth_approvals.status IS '状态（Approve或Deny）';  
COMMENT ON COLUMN oauth_approvals.expiresat IS '过期时间';  
COMMENT ON COLUMN oauth_approvals.lastmodifiedat IS '最终修改时间'; 
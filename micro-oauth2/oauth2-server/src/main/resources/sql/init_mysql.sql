
-- ----------------------------
-- Table structure for authorities
-- ----------------------------
/*DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ;*/

-- ----------------------------
-- Table structure for clientdetails
-- ----------------------------
/*DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails` (
  `appId` varchar(128) NOT NULL,
  `resourceIds` varchar(128) DEFAULT NULL,
  `appSecret` varchar(128) DEFAULT NULL,
  `scope` text DEFAULT NULL,
  `grantTypes` text DEFAULT NULL,
  `redirectUrl` text DEFAULT NULL,
  `authorities` text DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additionalInformation` text DEFAULT NULL,
  `autoApproveScopes` text DEFAULT NULL,
  PRIMARY KEY (`appId`)
) ;*/

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(128) DEFAULT NULL COMMENT 'MD5加密的access_token的值',
  `token` text COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
  `authentication_id` varchar(128) NOT NULL COMMENT 'MD5加密过的username,client_id,scope',
  `user_name` varchar(128) DEFAULT NULL COMMENT '登录的用户名',
  `client_id` text DEFAULT NULL COMMENT '客户端ID',
  `authentication` text COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据',
  `refresh_token` varchar(128) DEFAULT NULL COMMENT 'MD5加密果的refresh_token的值',
  PRIMARY KEY (`authentication_id`)
);

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(128) DEFAULT NULL COMMENT '登录的用户名',
  `clientId` varchar(128) DEFAULT NULL COMMENT '客户端ID',
  `scope` text DEFAULT NULL COMMENT '申请的权限',
  `status` varchar(10) DEFAULT NULL COMMENT '状态（Approve或Deny）',
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '过期时间',
  `lastModifiedAt` datetime DEFAULT NULL COMMENT '最终修改时间'
) ;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL COMMENT '客户端ID',
  `resource_ids` text DEFAULT NULL COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
  `client_secret` varchar(128) DEFAULT NULL COMMENT '客户端密匙',
  `scope` text DEFAULT NULL COMMENT '客户端申请的权限范围',
  `authorized_grant_types` text DEFAULT NULL COMMENT '客户端支持的grant_type',
  `web_server_redirect_uri` text DEFAULT NULL COMMENT '重定向URI',
  `authorities` text DEFAULT NULL COMMENT '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔',
  `access_token_validity` int(11) DEFAULT NULL COMMENT '访问令牌有效时间值(单位:秒)',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT '更新令牌有效时间值(单位:秒)',
  `additional_information` text DEFAULT NULL COMMENT '预留字段',
  `autoapprove` text DEFAULT NULL COMMENT '用户是否自动Approval操作',
  PRIMARY KEY (`client_id`)
) ;

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(128) DEFAULT NULL COMMENT 'MD5加密的access_token值',
  `token` text COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
  `authentication_id` varchar(128) NOT NULL COMMENT 'MD5加密过的username,client_id,scope',
  `user_name` varchar(128) DEFAULT NULL COMMENT '登录的用户名',
  `client_id` varchar(128) DEFAULT NULL COMMENT '客户端ID',
  PRIMARY KEY (`authentication_id`)
) ;

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL COMMENT  '授权码(未加密)',
  `authentication` text COMMENT  'AuthorizationRequestHolder.java对象序列化后的二进制数据'
) ;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(128) DEFAULT NULL COMMENT 'MD5加密过的refresh_token的值',
  `token` text COMMENT 'OAuth2RefreshToken.java对象序列化后的二进制数据',
  `authentication` text COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据'
) ;

-- ----------------------------
-- Table structure for users
-- ----------------------------
/*DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
);*/


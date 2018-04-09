
-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ;

-- ----------------------------
-- Table structure for clientdetails
-- ----------------------------
DROP TABLE IF EXISTS `clientdetails`;
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
) ;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(128) DEFAULT NULL,
  `token` text,
  `authentication_id` varchar(128) NOT NULL,
  `user_name` varchar(128) DEFAULT NULL,
  `client_id` text DEFAULT NULL,
  `authentication` text,
  `refresh_token` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
);

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(128) DEFAULT NULL,
  `clientId` varchar(128) DEFAULT NULL,
  `scope` text DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastModifiedAt` datetime DEFAULT NULL
) ;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` text DEFAULT NULL,
  `client_secret` varchar(128) DEFAULT NULL,
  `scope` text DEFAULT NULL,
  `authorized_grant_types` text DEFAULT NULL,
  `web_server_redirect_uri` text DEFAULT NULL,
  `authorities` text DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` text DEFAULT NULL,
  `autoapprove` text DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ;

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(128) DEFAULT NULL,
  `token` text,
  `authentication_id` varchar(128) NOT NULL,
  `user_name` varchar(128) DEFAULT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ;

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` text
) ;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(128) DEFAULT NULL,
  `token` text,
  `authentication` text
) ;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
);

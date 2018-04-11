
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
COMMENT ON COLUMN oauth_access_token.token_id IS 'MD5���ܵ�access_token��ֵ';  
COMMENT ON COLUMN oauth_access_token.token IS 'OAuth2AccessToken.java�������л���Ķ���������';  
COMMENT ON COLUMN oauth_access_token.authentication_id IS 'MD5���ܹ���username,client_id,scope';  
COMMENT ON COLUMN oauth_access_token.user_name IS '��¼���û���';  
COMMENT ON COLUMN oauth_access_token.client_id IS '�ͻ���ID';  
COMMENT ON COLUMN oauth_access_token.authentication IS 'OAuth2Authentication.java�������л���Ķ���������';  
COMMENT ON COLUMN oauth_access_token.refresh_token IS 'MD5���ܹ���refresh_token��ֵ';  
  
CREATE TABLE oauth_client_details  
(  
  client_id VARCHAR(255)   PRIMARY KEY, -- �ͻ���ID  
  resource_ids VARCHAR(255), -- ��ԴID����,�����Դʱ�ö���(,)�ָ�  
  client_secret VARCHAR(255), -- �ͻ����ܳ�  
  scope VARCHAR(255), -- �ͻ��������Ȩ�޷�Χ  
  authorized_grant_types VARCHAR(255), -- �ͻ���֧�ֵ�grant_type  
  web_server_redirect_uri VARCHAR(255), -- �ض���URI  
  authorities VARCHAR(255), -- �ͻ�����ӵ�е�Spring Security��Ȩ��ֵ������ö���(,)�ָ�  
  access_token_validity integer, -- ����������Чʱ��ֵ(��λ:��)  
  refresh_token_validity integer, -- ����������Чʱ��ֵ(��λ:��)  
  additional_information VARCHAR(255), -- Ԥ���ֶ�  
  autoapprove VARCHAR(255)-- �û��Ƿ��Զ�Approval����  
);  

COMMENT ON COLUMN oauth_client_details.client_id IS '�ͻ���ID';  
COMMENT ON COLUMN oauth_client_details.resource_ids IS '��ԴID����,�����Դʱ�ö���(,)�ָ�';  
COMMENT ON COLUMN oauth_client_details.client_secret IS '�ͻ����ܳ�';  
COMMENT ON COLUMN oauth_client_details.scope IS '�ͻ��������Ȩ�޷�Χ';  
COMMENT ON COLUMN oauth_client_details.authorized_grant_types IS '�ͻ���֧�ֵ�grant_type';  
COMMENT ON COLUMN oauth_client_details.web_server_redirect_uri IS '�ض���URI';  
COMMENT ON COLUMN oauth_client_details.authorities IS '�ͻ�����ӵ�е�Spring Security��Ȩ��ֵ������ö���(,)�ָ�';  
COMMENT ON COLUMN oauth_client_details.access_token_validity IS '����������Чʱ��ֵ(��λ:��)';  
COMMENT ON COLUMN oauth_client_details.refresh_token_validity IS '����������Чʱ��ֵ(��λ:��)';  
COMMENT ON COLUMN oauth_client_details.additional_information IS 'Ԥ���ֶ�';  
COMMENT ON COLUMN oauth_client_details.autoapprove IS '�û��Ƿ��Զ�Approval����'; 
 
create table oauth_refresh_token (
  create_time timestamp default systimestamp,
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
)  ;
COMMENT ON COLUMN oauth_refresh_token.token_id IS 'MD5���ܹ���refresh_token��ֵ';  
COMMENT ON COLUMN oauth_refresh_token.token IS 'OAuth2RefreshToken.java�������л���Ķ���������';  
COMMENT ON COLUMN oauth_refresh_token.authentication IS 'OAuth2Authentication.java�������л���Ķ���������';  

CREATE TABLE oauth_client_token  
(  
  token_id varchar2(256), -- MD5���ܵ�access_tokenֵ  
  token blob, -- OAuth2AccessToken.java�������л���Ķ���������  
  authentication_id  varchar2(256), -- MD5���ܹ���username,client_id,scope  
  user_name  varchar2(256), -- ��¼���û���  
  client_id  varchar2(256)-- �ͻ���ID  
);  
COMMENT ON COLUMN oauth_client_token.token_id IS 'MD5���ܵ�access_tokenֵ';  
COMMENT ON COLUMN oauth_client_token.token IS 'OAuth2AccessToken.java�������л���Ķ���������';  
COMMENT ON COLUMN oauth_client_token.authentication_id IS 'MD5���ܹ���username,client_id,scope';  
COMMENT ON COLUMN oauth_client_token.user_name IS '��¼���û���';  
COMMENT ON COLUMN oauth_client_token.client_id IS '�ͻ���ID';  
  
CREATE TABLE oauth_code  
(  
  code  varchar2(256), -- ��Ȩ��(δ����)  
  authentication blob -- AuthorizationRequestHolder.java�������л���Ķ���������  
);  
COMMENT ON COLUMN oauth_code.code IS '��Ȩ��(δ����)';  
COMMENT ON COLUMN oauth_code.authentication IS 'AuthorizationRequestHolder.java�������л���Ķ���������';  

CREATE TABLE oauth_approvals  
(  
  userid character varying(256), -- ��¼���û���  
  clientid character varying(256), -- �ͻ���ID  
  scope character varying(256), -- �����Ȩ��  
  status character varying(10), -- ״̬��Approve��Deny��  
  expiresat timestamp  , -- ����ʱ��  
  lastmodifiedat timestamp   -- �����޸�ʱ��  
);  
COMMENT ON COLUMN oauth_approvals.userid IS '��¼���û���';  
COMMENT ON COLUMN oauth_approvals.clientid IS '�ͻ���ID';  
COMMENT ON COLUMN oauth_approvals.scope IS '�����Ȩ��';  
COMMENT ON COLUMN oauth_approvals.status IS '״̬��Approve��Deny��';  
COMMENT ON COLUMN oauth_approvals.expiresat IS '����ʱ��';  
COMMENT ON COLUMN oauth_approvals.lastmodifiedat IS '�����޸�ʱ��'; 
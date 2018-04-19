package com.guoyicap.micro.config.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 系统用户表
 *  @author  张代浩
 */
@Entity
@Table(name = "t_s_user")
@PrimaryKeyJoinColumn(name = "id")
public class TSUser extends TSBaseUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String signatureFile;// 签名文件
	private String mobilePhone;// 手机
	private String officePhone;// 办公电话
	private String email;// 邮箱
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人ID*/
	private java.lang.String createBy;
	/**创建人名称*/
	private java.lang.String createName;
	/**修改时间*/
	private java.util.Date updateDate;
	/**修改人*/
	private java.lang.String updateBy;
	/**修改人名称*/
	private java.lang.String updateName;
	/**性别*/
	private java.lang.String sex;
	/**MAC系统*/
	private java.lang.Short mac;
	/**BS系统*/
	private java.lang.Short bs;
	/**CS系统*/
	private java.lang.Short cs;
	/**打印*/
	private java.lang.Short printdefault;
	/***/
	private java.lang.String mainpage;
	/***/
	private java.lang.String mastertype;
	/***/
	private java.lang.String theme;
	/***/
	private java.lang.String openstyle;
	/***/
	private java.lang.String type;
	/***/
	private java.lang.String servecode;
	/***/
	private java.lang.String station;
	/***/
	private java.lang.Integer serviceid;
	/***/
	private java.lang.String syscode;
	
	/**
	* @Fields province : 省
	*/ 
	private java.lang.String province;
	/**
	* @Fields city : 市
	*/ 
	private java.lang.String city;
	/**
	* @Fields area : 区
	*/ 
	private java.lang.String area;
	/**
	* @Fields maxHuiyuan : 最大绑定会员量
	*/ 
	private java.lang.Integer maxHuiyuan=30;
	/**
	* @Fields kefuparentuserid : 客服组长专用
	*/ 
	private java.lang.String kefuparentuserid; 	
	
	/**
	* @Fields idcard : 身份证号
	*/ 
	private java.lang.String idcard;
	/**
	* @Fields bankcode : 银行编号
	*/ 
	private java.lang.String bankcode;
	
	@Column(name = "signatureFile", length = 100)
	public String getSignatureFile() {
		return this.signatureFile;
	}

	public void setSignatureFile(String signatureFile) {
		this.signatureFile = signatureFile;
	}

	@Column(name = "mobilePhone", length = 30)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "officePhone", length = 20)
	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="create_date",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人ID
	 */
	@Column(name ="create_by",nullable=true,length=36)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人ID
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="create_name",nullable=true,length=36)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="update_date",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人ID
	 */
	@Column(name ="update_by",nullable=true,length=36)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人ID
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人名称
	 */
	@Column(name ="update_name",nullable=true,length=36)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	@Column(name ="sex",nullable=true,length=1)
	public java.lang.String getSex() {
		return sex;
	}

	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}
	@Column(name ="mac",nullable=true,length=1)
	public java.lang.Short getMac() {
		return mac;
	}

	public void setMac(java.lang.Short mac) {
		this.mac = mac;
	}
	@Column(name ="bs",nullable=true,length=1)
	public java.lang.Short getBs() {
		return bs;
	}

	public void setBs(java.lang.Short bs) {
		this.bs = bs;
	}
	@Column(name ="cs",nullable=true,length=1)
	public java.lang.Short getCs() {
		return cs;
	}

	public void setCs(java.lang.Short cs) {
		this.cs = cs;
	}
	@Column(name ="printdefault",nullable=true,length=1)
	public java.lang.Short getPrintdefault() {
		return printdefault;
	}

	public void setPrintdefault(java.lang.Short printdefault) {
		this.printdefault = printdefault;
	}
	@Column(name ="mainpage",nullable=true,length=100)
	public java.lang.String getMainpage() {
		return mainpage;
	}

	public void setMainpage(java.lang.String mainpage) {
		this.mainpage = mainpage;
	}
	@Column(name ="mastertype",nullable=true,length=50)
	public java.lang.String getMastertype() {
		return mastertype;
	}

	public void setMastertype(java.lang.String mastertype) {
		this.mastertype = mastertype;
	}
	@Column(name ="theme",nullable=true,length=50)
	public java.lang.String getTheme() {
		return theme;
	}

	public void setTheme(java.lang.String theme) {
		this.theme = theme;
	}
	@Column(name ="openstyle",nullable=true,length=3)
	public java.lang.String getOpenstyle() {
		return openstyle;
	}

	public void setOpenstyle(java.lang.String openstyle) {
		this.openstyle = openstyle;
	}
	@Column(name ="type",nullable=true,length=20)
	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}
	@Column(name ="servecode",nullable=true,length=50)
	public java.lang.String getServecode() {
		return servecode;
	}

	public void setServecode(java.lang.String servecode) {
		this.servecode = servecode;
	}
	@Column(name ="station",nullable=true,length=50)
	public java.lang.String getStation() {
		return station;
	}

	public void setStation(java.lang.String station) {
		this.station = station;
	}
	@Column(name ="serviceid",nullable=true,length=10)
	public java.lang.Integer getServiceid() {
		return serviceid;
	}

	public void setServiceid(java.lang.Integer serviceid) {
		this.serviceid = serviceid;
	}
	@Column(name ="syscode",nullable=true,length=50)
	public java.lang.String getSyscode() {
		return syscode;
	}

	public void setSyscode(java.lang.String syscode) {
		this.syscode = syscode;
	}
	@Column(name ="PROVINCE",nullable=true,length=6)
	public java.lang.String getProvince() {
		return province;
	}

	public void setProvince(java.lang.String province) {
		this.province = province;
	}
	@Column(name ="CITY",nullable=true,length=6)
	public java.lang.String getCity() {
		return city;
	}

	public void setCity(java.lang.String city) {
		this.city = city;
	}
	@Column(name ="AREA",nullable=true,length=6)
	public java.lang.String getArea() {
		return area;
	}

	public void setArea(java.lang.String area) {
		this.area = area;
	}
	@Column(name ="MAX_HUIYUAN",nullable=true,length=10)
	public java.lang.Integer getMaxHuiyuan() {
		return maxHuiyuan;
	}

	public void setMaxHuiyuan(java.lang.Integer maxHuiyuan) {
		this.maxHuiyuan = maxHuiyuan;
	}
	@Column(name ="KEFUPARENTUSERID",nullable=true,length=50)
	public java.lang.String getKefuparentuserid() {
		return kefuparentuserid;
	}

	public void setKefuparentuserid(java.lang.String kefuparentuserid) {
		this.kefuparentuserid = kefuparentuserid;
	}
	@Column(name ="IDCARD",nullable=true,length=50)
	public java.lang.String getIdcard() {
		return idcard;
	}

	public void setIdcard(java.lang.String idcard) {
		this.idcard = idcard;
	}
	@Column(name ="BANKCODE",nullable=true,length=50)
	public java.lang.String getBankcode() {
		return bankcode;
	}

	public void setBankcode(java.lang.String bankcode) {
		this.bankcode = bankcode;
	}
	
	
}
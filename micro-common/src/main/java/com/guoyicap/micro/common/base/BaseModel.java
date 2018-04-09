package com.guoyicap.micro.common.base;

import java.io.Serializable;

import javax.persistence.Transient;

public class BaseModel  implements Serializable{
	private static final long serialVersionUID = 1404672527582245038L;
	
	@Transient
    private Integer page = 1;
    @Transient
    private Integer rows = 10;
    @Transient
    private String sort = null;// 排序字段名
    @Transient
	private String order = "asc";// 按什么排序(asc,desc)
    
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
    
    
}

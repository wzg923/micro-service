package com.guoyicap.micro.common.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
@Entity
public abstract class IdEntity {
	private String id;

	@Transient
	private Integer page = 1;

	@Transient
	private Integer rows = 10;

	@Id
	// @GeneratedValue()
	// @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@GeneratedValue(generator = "UUID")
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		/*
		 * if(id ==null) { id=UUID.randomUUID().toString().replace("-", ""); }
		 */
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

}

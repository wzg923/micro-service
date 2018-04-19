package com.guoyicap.oauth2.model;

import java.io.Serializable;

public class Authority implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4153122042285146531L;
	private Long id;
    private String name;
    private String value;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
    
}

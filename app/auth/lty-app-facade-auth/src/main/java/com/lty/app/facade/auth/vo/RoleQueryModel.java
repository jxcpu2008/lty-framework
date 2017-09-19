package com.lty.app.facade.auth.vo;

import com.lty.framework.common.model.BaseModel;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月8日
 * @版本: 1.0
 */
public class RoleQueryModel extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 61465187960542948L;

	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
}
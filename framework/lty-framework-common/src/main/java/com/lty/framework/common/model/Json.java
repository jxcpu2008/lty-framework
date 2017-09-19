package com.lty.framework.common.model;

import java.io.Serializable;

/**
 * 
 * @描述:返回给页面的json数据对象
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class Json implements Serializable {
	private static final long serialVersionUID = -7743207517521826662L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;

	public boolean isSuccess() {
		return success;
	}

	public Json setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public Json setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Object getObj() {
		return obj;
	}

	public Json setObj(Object obj) {
		this.obj = obj;
		return this;
	}

}

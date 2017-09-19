package com.lty.app.web.auth.controller;

import com.lty.framework.common.model.Json;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface LoginControllerI {
	/**
	 * 用户login
	 * 
	 * 
	 * @return
	 */

	public Json login(String loginName, String password) throws Exception;

	/**
	 * 用户退出系统
	 * 
	 * 
	 * @return
	 */

	public Json logout() throws Exception;

}

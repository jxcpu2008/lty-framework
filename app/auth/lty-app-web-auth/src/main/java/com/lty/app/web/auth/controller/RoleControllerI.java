package com.lty.app.web.auth.controller;

import com.lty.app.facade.auth.model.Role;
import com.lty.app.facade.auth.vo.RoleQueryModel;
import com.lty.framework.common.model.Json;
import com.lty.framework.common.page.Page;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface RoleControllerI {

	public Page findRoleResources(RoleQueryModel role) throws Exception;

	public Json add(Role role) throws Exception;

	public Json remove(String id) throws Exception;

	public Json edit(Role role) throws Exception;

	public Json editMenu(Role role) throws Exception;

	public Page combogrid(RoleQueryModel role) throws Exception;

	public Json getMenuIdsByPrimaryKey(String roleId) throws Exception;
}
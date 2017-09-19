package com.lty.app.facade.auth.service;

import com.lty.app.facade.auth.model.Role;
import com.lty.app.facade.auth.vo.RoleQueryModel;
import com.lty.framework.common.facade.BaseQueryFacadeI;
import com.lty.framework.common.page.Page;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月8日
 * @版本: 1.0
 */
public interface RoleQueryFacadeI extends BaseQueryFacadeI<Role, RoleQueryModel> {

	@SuppressWarnings("rawtypes")
	public Page findRoleResources(RoleQueryModel role) throws Exception;

}

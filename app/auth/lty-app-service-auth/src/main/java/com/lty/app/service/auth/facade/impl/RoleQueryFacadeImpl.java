package com.lty.app.service.auth.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lty.app.facade.auth.model.Role;
import com.lty.app.facade.auth.service.RoleQueryFacadeI;
import com.lty.app.facade.auth.vo.RoleQueryModel;
import com.lty.app.service.auth.biz.RoleServiceI;
import com.lty.app.service.auth.facade.impl.base.BaseQueryFacade;
import com.lty.framework.common.page.Page;
import com.lty.framework.core.service.BaseServiceI;

/**
 * 
 * @描述: 
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@Component("roleQueryFacade")
public class RoleQueryFacadeImpl extends BaseQueryFacade<Role, RoleQueryModel> implements RoleQueryFacadeI {

	@Resource
	private RoleServiceI roleService;

	public BaseServiceI<Role, RoleQueryModel> getService() {
		return roleService;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page findRoleResources(RoleQueryModel role) throws Exception {
		// TODO Auto-generated method stub
		return roleService.findRoleAndResources(role);
	}

}

package com.lty.app.service.auth.facade.impl;

import org.springframework.stereotype.Component;

import com.lty.app.facade.auth.model.Role;
import com.lty.app.facade.auth.service.RoleManagerFacadeI;
import com.lty.app.facade.auth.vo.RoleQueryModel;
import com.lty.app.service.auth.biz.RoleServiceI;
import com.lty.app.service.auth.facade.impl.base.BaseManagerFacade;
import com.lty.framework.core.service.BaseServiceI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@Component("roleManagerFacade")
public class RoleManagerFacadeImpl extends BaseManagerFacade<Role, RoleQueryModel> implements RoleManagerFacadeI {
	@javax.annotation.Resource
	private RoleServiceI roleService;

	@Override
	public BaseServiceI<Role, RoleQueryModel> getService() {
		return roleService;
	}

	@Override
	public int add(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleService.add(role);
	}

	@Override
	public int remove(String id) throws Exception {
		// TODO Auto-generated method stub
		return roleService.remove(id);
	}

	@Override
	public int edit(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleService.edit(role);
	}

	@Override
	public int editMenu(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleService.editMenu(role);
	}

	@Override
	public String getMenuIdsByPrimaryKey(String roleId) {
		// TODO Auto-generated method stub
		return roleService.getMenuIdsByPrimaryKey(roleId);
	}

}

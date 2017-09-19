package com.lty.app.service.auth.biz;

import com.lty.app.facade.auth.model.Role;
import com.lty.app.facade.auth.vo.RoleQueryModel;
import com.lty.framework.common.page.Page;
import com.lty.framework.core.service.BaseServiceI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface RoleServiceI extends BaseServiceI<Role, RoleQueryModel> {
	public int add(Role role);

	public int remove(String id);

	public int edit(Role role);

	@SuppressWarnings("rawtypes")
	public Page findRoleAndResources(RoleQueryModel role);

	public int editMenu(Role role);

	public String getMenuIdsByPrimaryKey(String roleId);

}

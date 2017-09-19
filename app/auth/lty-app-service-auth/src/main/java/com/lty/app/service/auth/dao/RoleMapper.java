package com.lty.app.service.auth.dao;

import java.util.List;

import com.lty.app.facade.auth.model.Role;
import com.lty.app.facade.auth.vo.RoleQueryModel;
import com.lty.framework.core.dao.BaseDAO;

/**
 * 
 * @描述: 
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface RoleMapper extends BaseDAO<Role, RoleQueryModel> {
	public int add(Role role);

	public int remove(Role role);

	public int edit(Role role);

	public List<Role> findRoleAndResources(RoleQueryModel role);

	public int countRoles(RoleQueryModel role);

}
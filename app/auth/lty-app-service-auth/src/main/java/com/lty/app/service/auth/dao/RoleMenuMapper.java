package com.lty.app.service.auth.dao;

import java.util.List;

import com.lty.app.facade.auth.model.RoleMenu;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface RoleMenuMapper {
	int deleteByPrimaryKey(String id);

	int insert(RoleMenu record);

	int insertSelective(RoleMenu record);

	RoleMenu selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(RoleMenu record);

	int updateByPrimaryKey(RoleMenu record);

	int deleteByRoleMenuceRoleId(String roleId);

	List<RoleMenu> findRoleMenusByRoleId(String roleId);
}
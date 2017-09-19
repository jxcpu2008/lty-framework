package com.lty.app.service.auth.dao;

import com.lty.app.facade.auth.model.UserRole;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface UserRoleMapper {
	int deleteByPrimaryKey(String id);

	int insert(UserRole record);

	int insertSelective(UserRole record);

	UserRole selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(UserRole record);

	int updateByPrimaryKey(UserRole record);

	int deleteUserRoleByRoleId(String roleId);

	int deleteUserRoleByUserId(String userId);
}
package com.lty.app.service.auth.dao;

import com.lty.app.facade.auth.model.RoleResource;

/**
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface RoleResourceMapper {
	int deleteByPrimaryKey(String id);

	int insert(RoleResource record);

	int insertSelective(RoleResource record);

	RoleResource selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(RoleResource record);

	int updateByPrimaryKey(RoleResource record);

	int deleteRoleResourceByRoleId(String roleId);

}
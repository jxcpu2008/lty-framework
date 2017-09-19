package com.lty.app.service.auth.biz.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.lty.app.facade.auth.model.Role;
import com.lty.app.facade.auth.model.RoleMenu;
import com.lty.app.facade.auth.model.RoleResource;
import com.lty.app.facade.auth.vo.RoleQueryModel;
import com.lty.app.service.auth.biz.RoleServiceI;
import com.lty.app.service.auth.dao.RoleMapper;
import com.lty.app.service.auth.dao.RoleMenuMapper;
import com.lty.app.service.auth.dao.RoleResourceMapper;
import com.lty.app.service.auth.dao.UserRoleMapper;
import com.lty.framework.common.exceptions.BizException;
import com.lty.framework.common.page.Page;
import com.lty.framework.core.dao.BaseDAO;
import com.lty.framework.core.service.BaseService;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@Service("roleService")
public class RoleServiceImpl extends BaseService<Role, RoleQueryModel> implements RoleServiceI {
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RoleResourceMapper roleResourceMapper;
	@Resource
	private RoleMenuMapper roleMenuMapper;
	@Resource
	private UserRoleMapper userRoleMapper;

	@SuppressWarnings("rawtypes")
	@Override
	public BaseDAO getDao() {
		// TODO Auto-generated method stub
		return roleMapper;
	}

	@Override
	public int add(Role r) {
		if (StringUtils.isEmpty(r.getId())) {
			r.setId(UUID.randomUUID().toString());
		}
		int insertSelective = roleMapper.insertSelective(r);
		if (insertSelective == 0) {
			throw BizException.DB_INSERT_RESULT_0;

		} else {
			if (r.getResourceIds() != null) {
				for (String resourceId : r.getResourceIds().split(",")) {
					RoleResource rr = new RoleResource();
					rr.setId(UUID.randomUUID().toString());
					rr.setResourceId(resourceId);
					rr.setRoleId(r.getId());
					int insert = roleResourceMapper.insert(rr);
					if (insert == 0)
						throw BizException.DB_INSERT_RESULT_0;

				}
			}
		}

		return insertSelective;
	}

	@Override
	public int remove(String id) {

		if (StringUtils.isEmpty(id))
			throw BizException.DB_ERROR_PARAM_0;
		int deleteByPrimaryKey = roleMapper.deleteByPrimaryKey(id);
		if (deleteByPrimaryKey == 0)
			throw BizException.DB_DELETE_RESULT_0;
		roleResourceMapper.deleteRoleResourceByRoleId(id);
		roleMenuMapper.deleteByRoleMenuceRoleId(id);
		userRoleMapper.deleteUserRoleByUserId(id);
		return deleteByPrimaryKey;
	}

	@Override
	public int edit(Role r) {

		int updateByPrimaryKey = roleMapper.updateByPrimaryKey(r);
		if (updateByPrimaryKey == 0) {
			throw BizException.DB_UPDATE_RESULT_0;

		} else {
			roleResourceMapper.deleteRoleResourceByRoleId(r.getId());
			if (r.getResourceIds() != null) {
				for (String resourceId : r.getResourceIds().split(",")) {
					RoleResource rr = new RoleResource();
					rr.setId(UUID.randomUUID().toString());
					rr.setResourceId(resourceId);
					rr.setRoleId(r.getId());
					int insert = roleResourceMapper.insert(rr);
					if (insert == 0)
						throw BizException.DB_INSERT_RESULT_0;

				}
			}
		}
		return updateByPrimaryKey;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page findRoleAndResources(RoleQueryModel rqm) {
		int countRoles = roleMapper.countRoles(rqm);
		rqm.getPageModel().setTotal(countRoles);
		List<Role> list = roleMapper.findRoleAndResources(rqm);
		rqm.getPageModel().setRows(list);
		rqm.getPageModel().setTotal(list.size());
		return rqm.getPageModel();
	}

	@Override
	public int editMenu(Role r) {
		int insertCount = 0;
		int deleteRoleResourceByRoleId = roleMenuMapper.deleteByRoleMenuceRoleId(r.getId());
		insertCount += deleteRoleResourceByRoleId;
		if (r.getMenuIds() != null) {
			for (String menuId : r.getMenuIds().split(",")) {
				RoleMenu rm = new RoleMenu();
				rm.setId(UUID.randomUUID().toString());
				rm.setMenuId(menuId);
				rm.setRoleId(r.getId());
				int insert = roleMenuMapper.insert(rm);
				if (insert == 0)
					throw BizException.DB_INSERT_RESULT_0;
				insertCount += insert;
			}
		}
		return insertCount;
	}

	@Override
	public String getMenuIdsByPrimaryKey(String roleId) {
		StringBuilder sb = null;
		if (StringUtils.isEmpty(roleId))
			throw BizException.DB_ERROR_PARAM_0;
		List<RoleMenu> list = roleMenuMapper.findRoleMenusByRoleId(roleId);
		if (!CollectionUtils.isEmpty(list)) {
			sb = new StringBuilder();
			for (RoleMenu rm : list) {
				sb.append(rm.getMenuId()).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		if (sb != null) {
			return sb.toString();
		}
		return null;

	}
}

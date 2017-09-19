package com.lty.app.web.auth.controller.impl;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lty.app.facade.auth.model.Role;
import com.lty.app.facade.auth.service.RoleManagerFacadeI;
import com.lty.app.facade.auth.service.RoleQueryFacadeI;
import com.lty.app.facade.auth.vo.RoleQueryModel;
import com.lty.app.web.auth.controller.RoleControllerI;
import com.lty.framework.common.facade.BaseManagerFacadeI;
import com.lty.framework.common.facade.BaseQueryFacadeI;
import com.lty.framework.common.model.Json;
import com.lty.framework.common.page.Page;
import com.lty.framework.web.controller.BaseController;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@SuppressWarnings("all")
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role, RoleQueryModel> implements RoleControllerI {
	@Resource
	private RoleManagerFacadeI roleManagerFacade;
	@Resource
	private RoleQueryFacadeI roleQueryFacade;

	@Override
	public BaseManagerFacadeI<Role> getManagerFacade() {
		return roleManagerFacade;
	}

	@Override
	public BaseQueryFacadeI<Role, RoleQueryModel> getQueryFacade() {
		return roleQueryFacade;
	}

	@RequestMapping(value = "/findRoleResources", method = RequestMethod.GET)
	public Page findRoleResources(RoleQueryModel role) throws Exception {
		return roleQueryFacade.findRoleResources(role);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Json add(Role role) throws Exception {

		return roleManagerFacade.add(role) > 0 ? setSimpleSuccess(role) : setFailed();
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public Json remove(String id) throws Exception {
		return roleManagerFacade.remove(id) > 0 ? setSimpleSuccess(id) : setFailed();

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Json edit(Role role) throws Exception {

		return roleManagerFacade.edit(role) > 0 ? setSimpleSuccess(role) : setFailed();
	}

	@RequestMapping(value = "/combogrid", method = RequestMethod.GET)
	public Page combogrid(RoleQueryModel role) throws Exception {
		return roleQueryFacade.findRoleResources(role);
	}

	@RequestMapping(value = "/editMenu", method = RequestMethod.POST)
	public Json editMenu(Role role) throws Exception {

		return roleManagerFacade.editMenu(role) > 0 ? setSimpleSuccess(role) : setFailed();
	}

	@RequestMapping(value = "/getMenuIdsByPrimaryKey", method = RequestMethod.GET)
	public Json getMenuIdsByPrimaryKey(String roleId) throws Exception {
		return setSimpleSuccess(roleManagerFacade.getMenuIdsByPrimaryKey(roleId));
	}

}

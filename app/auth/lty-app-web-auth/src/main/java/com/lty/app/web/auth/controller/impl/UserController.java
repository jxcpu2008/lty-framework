package com.lty.app.web.auth.controller.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lty.app.facade.auth.model.User;
import com.lty.app.facade.auth.service.UserManagerFacadeI;
import com.lty.app.facade.auth.service.UserQueryFacadeI;
import com.lty.app.facade.auth.vo.UserQueryModel;
import com.lty.app.web.auth.controller.UserControllerI;
import com.lty.framework.common.enumeration.type.UserStatus;
import com.lty.framework.common.enumeration.type.UserType;
import com.lty.framework.common.facade.BaseManagerFacadeI;
import com.lty.framework.common.facade.BaseQueryFacadeI;
import com.lty.framework.common.model.Json;
import com.lty.framework.common.page.Page;
import com.lty.framework.web.controller.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@SuppressWarnings("all")
@RestController
@RequestMapping("/user")
@Api(value = "user", description = "有关于用户的CURD操作", position = 5)
public class UserController extends BaseController<User, UserQueryModel> implements UserControllerI {
	@Resource
	private UserManagerFacadeI userManagerFacade;
	@Resource
	private UserQueryFacadeI userQueryFacade;

	@Override
	public BaseManagerFacadeI<User> getManagerFacade() {
		return userManagerFacade;
	}

	@Override
	public BaseQueryFacadeI<User, UserQueryModel> getQueryFacade() {
		return userQueryFacade;
	}

	@ApiOperation(value = "显示用户", httpMethod = "GET", notes = "显示用户")
	@RequestMapping(value = "/{id}/showUser", method = RequestMethod.GET)
	public String showUser(@PathVariable String id, HttpServletRequest request) {
		User u = userQueryFacade.selectByPrimaryKey(id);
		request.setAttribute("user", u);
		return "showUser";
	}

	// 提供json视图
	@ApiOperation(value = "分页显示用户及其对应角色列表", httpMethod = "GET", notes = "显示用户列表")
	@RequestMapping(value = "/findUserAndRolesByPage", method = RequestMethod.GET)
	public Page findUserAndRolesByPage(UserQueryModel uqm) throws Exception {
		// 枚举数据库常量示例
		Page pageData = userQueryFacade.findUserAndRoles(uqm);
		List<User> userList = pageData.getRows();
		for (User user : userList) {
			UserStatus userStatus = UserStatus.valueOf(Integer.parseInt(user.getStatus()));
			user.setStatus(userStatus.value());
			
			UserType userType = UserType.valueOf(Integer.parseInt(user.getType()));
			user.setType(userType.desc());
		}
		return pageData;
		
//		return userQueryFacade.findUserAndRoles(uqm);
	}
	
	// 提供jsp视图
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listUser(UserQueryModel uqm) throws Exception {
		ModelAndView mv = new ModelAndView("user/page");
		uqm.setSort("login_name");
		uqm.setOrder("asc");
		Page page = userQueryFacade.findUserAndRoles(uqm);
		mv.addObject("page", page);
		return mv;
	}

	@ApiOperation(value = "修改用户", httpMethod = "POST", notes = "修改用户")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Json edit(User user) throws Exception {
		return userManagerFacade.edit(user) > 0 ? setSimpleSuccess(user) : setFailed();
	}
}
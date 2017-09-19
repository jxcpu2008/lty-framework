package com.lty.app.service.auth.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lty.app.facade.auth.model.User;
import com.lty.app.facade.auth.service.UserQueryFacadeI;
import com.lty.app.facade.auth.vo.UserQueryModel;
import com.lty.app.service.auth.biz.UserServiceI;
import com.lty.app.service.auth.facade.impl.base.BaseQueryFacade;
import com.lty.framework.common.exceptions.LoginException;
import com.lty.framework.common.page.Page;
import com.lty.framework.core.service.BaseServiceI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@Component("userQueryFacade")
public class UserQueryFacadeImpl extends BaseQueryFacade<User, UserQueryModel> implements UserQueryFacadeI {

	@Resource
	private UserServiceI userService;

	public BaseServiceI<User, UserQueryModel> getService() {
		return userService;
	}

	@Override
	public User login(User u) {
		return userService.login(u);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page findUserAndRoles(UserQueryModel uqm) throws LoginException {
		return userService.findUserAndRoles(uqm);
	}

	@Override
	public User findUserByLoginName(String loginName) throws LoginException {

		return userService.findUserByLoginName(loginName);
	}

}

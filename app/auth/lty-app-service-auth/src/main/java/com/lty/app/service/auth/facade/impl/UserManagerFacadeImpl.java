package com.lty.app.service.auth.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lty.app.facade.auth.model.User;
import com.lty.app.facade.auth.service.UserManagerFacadeI;
import com.lty.app.facade.auth.vo.UserQueryModel;
import com.lty.app.service.auth.biz.UserServiceI;
import com.lty.app.service.auth.facade.impl.base.BaseManagerFacade;
import com.lty.framework.core.service.BaseServiceI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@Component("userManagerFacade")
public class UserManagerFacadeImpl extends BaseManagerFacade<User, UserQueryModel> implements UserManagerFacadeI {
	@Resource
	private UserServiceI userService;

	@Override
	public BaseServiceI<User, UserQueryModel> getService() {
		return userService;
	}

	public int edit(User user) {
		return userService.edit(user);
	}

}

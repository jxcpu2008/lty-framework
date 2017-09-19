package com.lty.app.facade.auth.service;

import com.lty.app.facade.auth.model.User;
import com.lty.app.facade.auth.vo.UserQueryModel;
import com.lty.framework.common.exceptions.LoginException;
import com.lty.framework.common.facade.BaseQueryFacadeI;
import com.lty.framework.common.page.Page;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月8日
 * @版本: 1.0
 */
public interface UserQueryFacadeI extends BaseQueryFacadeI<User, UserQueryModel> {

	public User login(User u) throws LoginException;

	public User findUserByLoginName(String loginName) throws LoginException;

	@SuppressWarnings("rawtypes")
	public Page findUserAndRoles(UserQueryModel uqm) throws LoginException;;

}

package com.lty.app.facade.auth.service;

import com.lty.app.facade.auth.model.User;
import com.lty.framework.common.facade.BaseManagerFacadeI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月8日
 * @版本: 1.0
 */
public interface UserManagerFacadeI extends BaseManagerFacadeI<User> {

	public int edit(User user);

}

package com.lty.framework.web.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lty.framework.common.constant.LogConstant;

/**
 * 
 * @描述: 登录的处理工具类
 * TODO 后续要修改为从redis缓存中读取用户信息
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public final class LoginHelper {
	
	private static Logger logger = LoggerFactory.getLogger(LoginHelper.class);

	private LoginHelper() {
	}

	/**
	 * 
	 * @功能：用户登录
	 * 
	 * @param account
	 * @param password
	 * @return Boolean
	 */
	public static final Boolean login(String account, String password) {
		
		UsernamePasswordToken token = new UsernamePasswordToken(account, password);
		token.setRememberMe(true);
		Subject currentUser = SecurityUtils.getSubject();
		logger.info(LogConstant.LOG_MARK + currentUser.getSession().getId());
		currentUser.login(token);
		
		return currentUser.isAuthenticated();
	}

	/**
	 * 
	 * @功能：用户退出
	 * 
	 * @return Boolean
	 */
	public static final Boolean logout() {
		
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		return currentUser.isAuthenticated();
	}
}

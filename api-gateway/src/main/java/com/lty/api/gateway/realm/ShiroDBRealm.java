package com.lty.api.gateway.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lty.app.facade.auth.constant.EncryptConstant;
import com.lty.app.facade.auth.model.User;
import com.lty.app.facade.auth.service.UserQueryFacadeI;
import com.lty.framework.common.constant.LogConstant;
import com.lty.framework.common.constant.LoginConstant;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class ShiroDBRealm extends AuthorizingRealm {
	@Resource
	private UserQueryFacadeI userQueryFacade;
	private static Logger logger = LoggerFactory.getLogger(ShiroDBRealm.class);

	/**
	 * 用户切换岗位时清除缓存的信息
	 */
	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
		return super.getAuthorizationInfo(principals);
	}

	@SuppressWarnings("unused")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		User u = (User) getAvailablePrincipal(principals);
		// 通过用户名去获得用户的所有资源，并把资源存入info中
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> s = new HashSet<String>();
		s.add("p1");
		s.add("p2");
		info.setStringPermissions(s);
		Set<String> r = new HashSet<String>();
		r.add("r1");
		r.add("r2");
		info.setRoles(r);
		Subject currentUser = SecurityUtils.getSubject();
		logger.info(LogConstant.LOG_MARK + "*********************" + currentUser.getSession().getId());
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		/* 传统登录方式 */
		// User u = new User();
		// String password = String.valueOf(token.getPassword());
		// u.setLoginName(token.getUsername());
		// u.setPassword(password);
		// logger.info(LogConstant.LOG_MARK + u.getPassword());
		// User user = userQueryFacade.login(u);

		User user = userQueryFacade.findUserByLoginName(token.getUsername());
		if (user != null) {
			// 数据库状态字段类型为varchar，则需要进行字符串比较
//			if (!LoginConstant.NORMAL_USER.equals(user.getStatus())) {
			// 数据库状态字段类型为char或者int，则直接是用==操作符比较
			if (LoginConstant.NORMAL_USER != user.getStatus()) {
				throw new LockedAccountException(LoginConstant.LOCKED_ACCOUNT);
			}
			/*
			 * return new SimpleAuthenticationInfo(user,
			 * (user.getPassword()).toLowerCase(), this.getName());
			 */
			return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword().toCharArray(),
					ByteSource.Util.bytes(EncryptConstant.ENCRYPT_SALT.getBytes()), getName());
		} else {
			throw new UnknownAccountException("没有查到用户记录！");
		}

	}
}
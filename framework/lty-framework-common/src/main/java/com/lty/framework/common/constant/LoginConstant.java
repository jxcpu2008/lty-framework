package com.lty.framework.common.constant;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class LoginConstant {
	public static final String LOGIN_AUTHENTICATION = "授权异常！";
	public static final String LOGIN_FAIL = "登录用户或密码不正确！";
	public static final String LOGIN_UNACCOUNT = "用户不存在！";
	public static final String LOCKED_ACCOUNT = "账号已经锁定！";
	// 数据库状态字段类型为char或者int，则声明常量类型为String
//	public static final String NORMAL_USER = "1";
	// 数据库状态字段类型为char或者int，则声明常量类型为int
	public static final int NORMAL_USER = 1;
}

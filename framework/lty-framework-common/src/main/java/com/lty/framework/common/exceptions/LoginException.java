package com.lty.framework.common.exceptions;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class LoginException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code; // 异常对应的返回码
	private String msgDes; // 异常对应的描述信息
	/**
	 * 数据库操作,insert返回0
	 */
	public static final LoginException LOGIN_PARAM_0 = new LoginException("403", "登录参数不正确！");
	public static final LoginException LOGIN_FAIL = new LoginException("401", "登录名或密码错误！");

	public LoginException() {
		super();
	}

	public LoginException(String message) {
		super(message);
		msgDes = message;
	}

	public LoginException(String code, String msgDes) {
		super(msgDes);
		this.code = code;
		this.msgDes = msgDes;
	}

	public String getRetCd() {
		return code;
	}

	public String getMsgDes() {
		return msgDes;
	}
}
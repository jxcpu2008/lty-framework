package com.lty.app.web.auth.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lty.app.web.auth.controller.LoginControllerI;
import com.lty.framework.common.model.Json;
import com.lty.framework.web.controller.base.BasicController;
import com.lty.framework.web.util.LoginHelper;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@RestController
@RequestMapping("/login")
@Api(value = "login", description = "登录信息接口")
public class LoginController extends BasicController implements LoginControllerI {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Override
	@ApiOperation(value = "登录", notes = "登录已經加密")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Json login(@ApiParam(value = "用户名或手机号") @RequestParam String loginName,
			@ApiParam(value = "密码") @RequestParam String password) throws Exception {
		return setSimpleSuccess(LoginHelper.login(loginName, password));
	}

	@Override
	@ApiOperation(value = "退出系统", notes = "退出系统")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public Json logout() throws Exception {
		LoginHelper.logout();
		return setSimpleSuccess();

	}

	@ApiOperation(value = "用户注册", notes = "这个是测试注册的接口")
	@PostMapping("/register")
	public ResponseEntity<ModelMap> regin(ModelMap modelMap,
			@ApiParam(required = true, value = "登录帐号") @RequestParam(value = "username") String account,
			@ApiParam(required = true, value = "登录密码") @RequestParam(value = "password") String password) {
		modelMap.put("obj", "测试对象");
		modelMap.put("msg", "测试内容提示");
		logger.debug("注册测试成功");
		return setSuccessModelMap(modelMap);

	}

}

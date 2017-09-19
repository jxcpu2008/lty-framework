/**
 * 
 */
package com.lty.framework.web.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lty.framework.common.constant.ControllerConstant;
import com.lty.framework.common.constant.LogConstant;
import com.lty.framework.common.constant.LoginConstant;
import com.lty.framework.common.model.Json;
import com.lty.framework.web.util.HttpCode;

/**
 * 
 * @描述: 基础的控制类
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class BasicController {
	private static Logger logger = LoggerFactory.getLogger(BasicController.class);

	/**
	 * 
	 * @Title: exceptionHandler
	 * @Description: TODO(异常处理)
	 * @param @param
	 *            request
	 * @param @param
	 *            response
	 * @param @param
	 *            ex
	 * @param @return
	 * @param Exception
	 *            设定文件
	 * @return Json 返回类型
	 * 
	 */
	@ExceptionHandler(Exception.class)
	public Json exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex)
			throws Exception {
		if (ex instanceof UnknownAccountException) {
			logger.info(LogConstant.LOG_MARK + LoginConstant.LOGIN_UNACCOUNT + ex.getMessage());
			return setFailed(LoginConstant.LOGIN_UNACCOUNT);
		} else if (ex instanceof IncorrectCredentialsException) {
			logger.info(ex.getMessage());
			logger.info(LogConstant.LOG_MARK + LoginConstant.LOGIN_FAIL);
			logger.info(LogConstant.LOG_MARK + ex.getStackTrace());
			return setFailed(LoginConstant.LOGIN_FAIL);
		} else if (ex instanceof LockedAccountException) {
			logger.info(LogConstant.LOG_MARK + LoginConstant.Locked_Account + ex.getMessage());
			return setFailed(LogConstant.LOG_MARK);
		} else if (ex instanceof AuthenticationException) {
			logger.info(LogConstant.LOG_MARK + LoginConstant.LOGIN_AUTHENTICATION);
			logger.info(LogConstant.LOG_MARK + ex.getStackTrace());
			return setFailed(LoginConstant.LOGIN_AUTHENTICATION);
		} else {
			// 待定自定义异常
		}
		return setFailed(HttpCode.INTERNAL_SERVER_ERROR.value().toString());
	}

	/**
	 * 
	 * @Title: setSuccessModelMap
	 * @Description: TODO(标准格式设置成功响应代码)
	 * @param @param
	 *            modelMap 需要返回的数据modelmap
	 * @param @return
	 *            设定文件
	 * @return ResponseEntity<ModelMap> 返回类型
	 * 
	 */
	protected ResponseEntity<ModelMap> setSuccessModelMap(ModelMap modelMap) {
		return setSuccessModelMap(modelMap, null);
	}

	/** 设置成功响应代码 */
	/**
	 * 
	 * @Title: setSuccessModelMap
	 * @Description: TODO(标准格式设置成功响应代码)
	 * @param @param
	 *            modelMap 需要返回的数据modelmap
	 * @param @param
	 *            data 需要返回的数据集
	 * @param @return
	 *            设定文件
	 * @return ResponseEntity<ModelMap> 返回类型
	 * 
	 */
	protected ResponseEntity<ModelMap> setSuccessModelMap(ModelMap modelMap, Object data) {
		return setModelMap(modelMap, HttpCode.OK, data, null);
	}

	/**
	 * 
	 * 
	 * @Description: TODO(标准格式设置成功响应代码)
	 * @param @param
	 *            modelMap
	 * @param @param
	 *            code 代码
	 * @param @return
	 *            设定文件
	 * @return ResponseEntity<ModelMap> 返回类型
	 * 
	 */
	protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, HttpCode code) {
		return setModelMap(modelMap, code, null, null);
	}

	/**
	 * 
	 * @Title: setModelMap
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param
	 *            modelMap
	 * @param @param
	 *            code
	 * @param @param
	 *            data
	 * @param @param
	 *            msg
	 * @param @return
	 *            ResponseEntity<ModelMap>
	 * @return ResponseEntity<ModelMap> 返回类型
	 * 
	 */
	protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, HttpCode code, Object data, String msg) {
		modelMap.remove("void");
		if (data != null) {
			modelMap.put("data", data);
		}
		modelMap.put("httpCode", code.value());
		modelMap.put("msg", msg);
		modelMap.put("timestamp", System.currentTimeMillis());
		return ResponseEntity.ok(modelMap);
	}

	/**
	 * 
	 * @Title: setSimpleSuccess
	 * @Description: TODO(简单设置成功)
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setSimpleSuccess() {
		return setSimpleSuccess(null);
	}

	/**
	 * 
	 * @Title: setSimpleSuccess
	 * @Description: TODO(简单设置成功)
	 * @param @param
	 *            succecss
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setSimpleSuccess(boolean succecss) {
		return setSimpleSuccess(null);
	}

	/**
	 * 
	 * @Title: setSimpleSuccess
	 * @Description: TODO(简单设置成功)
	 * @param @param
	 *            obj 需要返回的数据集
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setSimpleSuccess(Object obj) {
		return setSimpleSuccess(ControllerConstant.OPERATOR_SUCESSCE, obj);
	}

	/**
	 * 
	 * @Title: setSimpleSuccess
	 * @Description: TODO(快速设置失败)
	 * @param @param
	 *            msg 返回的提示信息
	 * @param @param
	 *            obj 返回的数据集
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setSimpleSuccess(String msg, Object obj) {
		return new Json().setMsg(msg).setObj(obj).setSuccess(true);
	}

	/**
	 * 
	 * @Title: setFailed
	 * @Description: TODO(快速失败)
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setFailed() {
		return setFailed(ControllerConstant.OPERATOR_FAIL);
	}

	/**
	 * 
	 * @Title: setFailed
	 * @Description: TODO(快速设置失败)
	 * @param @param
	 *            msg 失败的提示信息
	 * @param @return
	 * @return 返回类型 Json
	 * 
	 */
	protected Json setFailed(String msg) {
		return new Json().setMsg(msg);
	}

}

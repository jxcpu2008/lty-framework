package com.lty.framework.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lty.framework.common.facade.BaseManagerFacadeI;
import com.lty.framework.common.facade.BaseQueryFacadeI;
import com.lty.framework.common.model.BaseModel;
import com.lty.framework.common.model.Json;
import com.lty.framework.common.page.Page;
import com.lty.framework.web.controller.base.BasicController;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * @描述: SpringMVC的控制父类
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@SuppressWarnings("all")
@RestController
public abstract class BaseController<M, QM extends BaseModel> extends BasicController implements BaseControllerI<M, QM> {
	
	public abstract BaseManagerFacadeI<M> getManagerFacade();
	public abstract BaseQueryFacadeI<M, QM> getQueryFacade();

	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.POST)
	public Json deleteByPrimaryKey(@ApiParam(value = "id") @RequestParam(required = true) String id) throws Exception {
		return getManagerFacade().deleteByPrimaryKey(id) > 0 ? setSimpleSuccess(id) : setFailed();
	}

	@ApiOperation(value = "新增用户", httpMethod = "POST", notes = "新增用户")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
//	public Json insert(@RequestBody M record) throws Exception {
	public Json insert(M record) throws Exception {
		return getManagerFacade().insert(record) > 0 ? setSimpleSuccess(record) : setFailed();
	}

	@ApiOperation(value = "复制用户", httpMethod = "POST", notes = "复制用户")
	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
//	public Json insertSelective(@RequestBody M record) throws Exception {
	public Json insertSelective(M record) throws Exception {
		return getManagerFacade().insertSelective(record) > 0 ? setSimpleSuccess(record) : setFailed();
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public M selectByPrimaryKey(@ApiParam(value = "id") @RequestParam(value = "id", required = true) String id) throws Exception {
		return getQueryFacade().selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
	public Json updateByPrimaryKeySelective(M record) throws Exception {
		return getManagerFacade().updateByPrimaryKeySelective(record) > 0 ? setSimpleSuccess(record) : setFailed();
	}

	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	public Json updateByPrimaryKey(M record) throws Exception {
		return getManagerFacade().updateByPrimaryKey(record) > 0 ? setSimpleSuccess(record) : setFailed();
	}

	@RequestMapping(value = "/findObjectsByPage", method = RequestMethod.GET)
	public Page findObjectsByPage(QM record) throws Exception {
		return getQueryFacade().findObjectsByPage(record);
	}

}

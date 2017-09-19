package com.lty.framework.web.controller;

import com.lty.framework.common.model.BaseModel;
import com.lty.framework.common.model.Json;
import com.lty.framework.common.page.Page;

/**
 * 
 * @描述: SpringMVC的控制父类的接口 - T-普通json對象，QM-帶分頁信息的對象
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface BaseControllerI<T, QM extends BaseModel> {

	public Json deleteByPrimaryKey(String id) throws Exception;

	public Json insert(T record) throws Exception;

	public Json insertSelective(T record) throws Exception;

	public T selectByPrimaryKey(String id) throws Exception;

	public Json updateByPrimaryKeySelective(T record) throws Exception;

	public Json updateByPrimaryKey(T record) throws Exception;

	public Page findObjectsByPage(QM record) throws Exception;

}

package com.lty.framework.core.service;

import com.lty.framework.common.model.BaseModel;
import com.lty.framework.common.page.Page;

/**
 * 
 * @描述:Service接口的父类-M-普通对象，QM-带分页信息的对象
 * 
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface BaseServiceI<M, QM extends BaseModel> {

	public int deleteByPrimaryKey(String id);

	public int insert(M record);

	public int insertSelective(M record);

	public M selectByPrimaryKey(String id);

	public int updateByPrimaryKeySelective(M record);

	public int updateByPrimaryKey(M record);

	@SuppressWarnings("rawtypes")
	public Page findObjectsByPage(QM record);
}

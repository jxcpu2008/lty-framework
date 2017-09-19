package com.lty.framework.common.facade;

import com.lty.framework.common.model.BaseModel;
import com.lty.framework.common.page.Page;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface BaseQueryFacadeI<M, QM extends BaseModel> {
	public M selectByPrimaryKey(String id);

	@SuppressWarnings("rawtypes")
	public Page findObjectsByPage(QM record);
}

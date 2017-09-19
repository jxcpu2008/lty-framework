package com.lty.app.service.auth.dao;

import com.lty.app.facade.auth.model.Resource;
import com.lty.app.facade.auth.vo.ResourceQueryModel;
import com.lty.framework.core.dao.BaseDAO;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface ResourceMapper extends BaseDAO<Resource, ResourceQueryModel> {
	public Resource findResourceByProperties(Resource r);

	public int remove(String id);

	public int updatePidByPid(String id);
}
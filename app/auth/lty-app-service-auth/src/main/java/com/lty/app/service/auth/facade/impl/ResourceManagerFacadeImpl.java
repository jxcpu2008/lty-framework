package com.lty.app.service.auth.facade.impl;

import org.springframework.stereotype.Component;

import com.lty.app.facade.auth.model.Resource;
import com.lty.app.facade.auth.service.ResourceManagerFacadeI;
import com.lty.app.facade.auth.vo.ResourceQueryModel;
import com.lty.app.service.auth.biz.ResourceServiceI;
import com.lty.app.service.auth.facade.impl.base.BaseManagerFacade;
import com.lty.framework.core.service.BaseServiceI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@Component("resourceManagerFacade")
public class ResourceManagerFacadeImpl extends BaseManagerFacade<Resource, ResourceQueryModel>
		implements ResourceManagerFacadeI {
	@javax.annotation.Resource
	private ResourceServiceI resourceService;

	@Override
	public BaseServiceI<Resource, ResourceQueryModel> getService() {
		return resourceService;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return resourceService.remove(id);
	}

	@Override
	public int add(Resource r) {
		// TODO Auto-generated method stub
		return resourceService.add(r);
	}

	@Override
	public int edit(Resource r) {
		// TODO Auto-generated method stub
		return resourceService.edit(r);
	}

}

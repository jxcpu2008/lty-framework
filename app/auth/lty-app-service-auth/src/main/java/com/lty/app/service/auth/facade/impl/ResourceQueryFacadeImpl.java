package com.lty.app.service.auth.facade.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lty.app.facade.auth.model.Resource;
import com.lty.app.facade.auth.service.ResourceQueryFacadeI;
import com.lty.app.facade.auth.vo.ResourceQueryModel;
import com.lty.app.service.auth.biz.ResourceServiceI;
import com.lty.app.service.auth.facade.impl.base.BaseQueryFacade;
import com.lty.framework.core.service.BaseServiceI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@Component("resourceQueryFacade")
public class ResourceQueryFacadeImpl extends BaseQueryFacade<Resource, ResourceQueryModel>
		implements ResourceQueryFacadeI {

	@javax.annotation.Resource
	private ResourceServiceI resourceService;

	public BaseServiceI<Resource, ResourceQueryModel> getService() {
		return resourceService;
	}

	@Override
	public List<Resource> findAllTreeNode() {
		// TODO Auto-generated method stub
		return resourceService.findAllTreeNode();
	}

	@Override
	public Resource findResourceByProperties(Resource r) {
		// TODO Auto-generated method stub
		return resourceService.findResourceByProperties(r);
	}

	@Override
	public List<Resource> treegrid() {
		// TODO Auto-generated method stub
		return resourceService.treegrid();
	}

}

package com.lty.app.web.auth.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lty.app.facade.auth.model.Resource;
import com.lty.app.facade.auth.service.ResourceManagerFacadeI;
import com.lty.app.facade.auth.service.ResourceQueryFacadeI;
import com.lty.app.facade.auth.vo.ResourceQueryModel;
import com.lty.app.web.auth.controller.ResourceControllerI;
import com.lty.framework.common.facade.BaseManagerFacadeI;
import com.lty.framework.common.facade.BaseQueryFacadeI;
import com.lty.framework.common.model.Json;
import com.lty.framework.web.controller.BaseController;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@SuppressWarnings("all")
@RestController
@RequestMapping("/resource")
public class ResourceController extends BaseController<Resource, ResourceQueryModel> implements ResourceControllerI {
	@javax.annotation.Resource
	private ResourceManagerFacadeI resourceManagerFacade;
	@javax.annotation.Resource
	private ResourceQueryFacadeI resourceQueryFacade;

	@Override
	public BaseManagerFacadeI<Resource> getManagerFacade() {
		return resourceManagerFacade;
	}

	@Override
	public BaseQueryFacadeI<Resource, ResourceQueryModel> getQueryFacade() {
		return resourceQueryFacade;
	}

	@RequestMapping(value = "/findAllTreeNode", method = RequestMethod.GET)

	public List<Resource> findAllTreeNode() {
		return resourceQueryFacade.findAllTreeNode();
	}

	@RequestMapping(value = "/treegrid", method = RequestMethod.GET)

	public List<Resource> treegrid() {
		return resourceQueryFacade.treegrid();
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)

	public Json remove(String id) {
		return resourceManagerFacade.remove(id) > 0 ? setSimpleSuccess(id) : setFailed();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)

	public Json add(Resource r) {

		return resourceManagerFacade.add(r) > 0 ? setSimpleSuccess(r) : setFailed();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)

	public Json edit(Resource r) {

		return resourceManagerFacade.edit(r) > 0 ? setSimpleSuccess(r) : setFailed();
	}

}

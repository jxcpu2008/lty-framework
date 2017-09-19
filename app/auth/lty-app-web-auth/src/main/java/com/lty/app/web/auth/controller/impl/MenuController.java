package com.lty.app.web.auth.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lty.app.facade.auth.model.Menu;
import com.lty.app.facade.auth.service.MenuManagerFacadeI;
import com.lty.app.facade.auth.service.MenuQueryFacadeI;
import com.lty.app.facade.auth.vo.MenuQueryModel;
import com.lty.app.web.auth.controller.MenuControllerI;
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
@RequestMapping("/menu")
public class MenuController extends BaseController<Menu, MenuQueryModel> implements MenuControllerI {
	@Resource
	private MenuManagerFacadeI menuManagerFacade;
	@Resource
	private MenuQueryFacadeI menuQueryFacade;

	@Override
	public BaseManagerFacadeI<Menu> getManagerFacade() {
		return menuManagerFacade;
	}

	@Override
	public BaseQueryFacadeI<Menu, MenuQueryModel> getQueryFacade() {
		return menuQueryFacade;
	}

	@RequestMapping(value = "/findAllTreeNode", method = RequestMethod.GET)

	public List<Menu> findAllTreeNode() {

		return menuQueryFacade.findAllTreeNode();
	}

	@RequestMapping(value = "/treegrid", method = RequestMethod.GET)

	public List<Menu> treegrid() {
		return menuQueryFacade.treegrid();
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)

	public Json remove(String id) {
		return menuManagerFacade.remove(id) > 0 ? setSimpleSuccess(id) : setFailed();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)

	public Json add(Menu menu) {

		return menuManagerFacade.add(menu) > 0 ? setSimpleSuccess(menu) : setFailed();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)

	public Json edit(Menu menu) {

		return menuManagerFacade.edit(menu) > 0 ? setSimpleSuccess(menu) : setFailed();
	}

}

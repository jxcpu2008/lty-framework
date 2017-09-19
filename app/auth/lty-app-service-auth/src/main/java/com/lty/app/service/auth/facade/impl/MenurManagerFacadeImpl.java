package com.lty.app.service.auth.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lty.app.facade.auth.model.Menu;
import com.lty.app.facade.auth.service.MenuManagerFacadeI;
import com.lty.app.facade.auth.vo.MenuQueryModel;
import com.lty.app.service.auth.biz.MenuServiceI;
import com.lty.app.service.auth.facade.impl.base.BaseManagerFacade;
import com.lty.framework.core.service.BaseServiceI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@Component("menuManagerFacade")
public class MenurManagerFacadeImpl extends BaseManagerFacade<Menu, MenuQueryModel> implements MenuManagerFacadeI {
	@Resource
	private MenuServiceI menuService;

	@Override
	public BaseServiceI<Menu, MenuQueryModel> getService() {
		return menuService;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return menuService.remove(id);
	}

	@Override
	public int add(Menu menu) {
		// TODO Auto-generated method stub
		return menuService.add(menu);
	}

	@Override
	public int edit(Menu menu) {
		// TODO Auto-generated method stub
		return menuService.edit(menu);
	}

}

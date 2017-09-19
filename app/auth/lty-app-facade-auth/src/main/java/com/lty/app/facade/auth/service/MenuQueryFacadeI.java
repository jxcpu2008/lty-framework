package com.lty.app.facade.auth.service;

import java.util.List;

import com.lty.app.facade.auth.model.Menu;
import com.lty.app.facade.auth.vo.MenuQueryModel;
import com.lty.framework.common.facade.BaseQueryFacadeI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月8日
 * @版本: 1.0
 */
public interface MenuQueryFacadeI extends BaseQueryFacadeI<Menu, MenuQueryModel> {

	public List<Menu> findAllTreeNode();

	public Menu findMenuByProperties(Menu m);

	public List<Menu> treegrid();

}

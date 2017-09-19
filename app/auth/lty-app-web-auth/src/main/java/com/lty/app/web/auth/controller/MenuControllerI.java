package com.lty.app.web.auth.controller;

import java.util.List;

import com.lty.app.facade.auth.model.Menu;
import com.lty.framework.common.model.Json;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface MenuControllerI {

	public List<Menu> findAllTreeNode();

	public List<Menu> treegrid();

	public Json remove(String id);

	public Json add(Menu menu);

	public Json edit(Menu menu);
}
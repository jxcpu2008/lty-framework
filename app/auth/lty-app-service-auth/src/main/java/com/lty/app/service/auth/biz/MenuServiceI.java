package com.lty.app.service.auth.biz;

import java.util.List;

import com.lty.app.facade.auth.model.Menu;
import com.lty.app.facade.auth.vo.MenuQueryModel;
import com.lty.framework.core.service.BaseServiceI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface MenuServiceI extends BaseServiceI<Menu, MenuQueryModel> {

	public Menu findMenuByProperties(Menu m);

	public List<Menu> findAllTreeNode();

	public List<Menu> treegrid();

	public int remove(String id);

	public int add(Menu menu);

	public int edit(Menu menu);

}

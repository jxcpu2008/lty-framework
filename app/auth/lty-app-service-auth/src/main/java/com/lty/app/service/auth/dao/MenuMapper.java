package com.lty.app.service.auth.dao;

import com.lty.app.facade.auth.model.Menu;
import com.lty.app.facade.auth.vo.MenuQueryModel;
import com.lty.framework.core.dao.BaseDAO;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface MenuMapper extends BaseDAO<Menu, MenuQueryModel> {
	public Menu findMenuByProperties(Menu m);

	public int remove(String id);

	public int updatePidByPid(String id);
}
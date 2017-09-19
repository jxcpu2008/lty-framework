package com.lty.framework.core.service;

import java.util.List;

import org.springframework.util.StringUtils;

import com.lty.framework.common.exceptions.BizException;
import com.lty.framework.common.model.BaseModel;
import com.lty.framework.common.page.Page;
import com.lty.framework.core.dao.BaseDAO;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@SuppressWarnings("all")
public abstract class BaseService<M, QM extends BaseModel> implements BaseServiceI<M, QM> {

	public abstract BaseDAO getDao();

	public int deleteByPrimaryKey(String id) {
		if (StringUtils.isEmpty(id))
			throw BizException.DB_ERROR_PARAM_0;
		return getDao().deleteByPrimaryKey(id);
	}

	public int insert(M record) {
		// TODO Auto-generated method stub
		return getDao().insert(record);
	}

	public int insertSelective(M record) {
		// TODO Auto-generated method stub
		return getDao().insertSelective(record);
	}

	public M selectByPrimaryKey(String id) {
		if (StringUtils.isEmpty(id))
			throw BizException.DB_ERROR_PARAM_0;
		return (M) getDao().selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(M record) {
		// TODO Auto-generated method stub
		return getDao().updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(M record) {
		// TODO Auto-generated method stub
		return getDao().updateByPrimaryKey(record);
	}

	public Page findObjectsByPage(QM qm) {
		// TODO Auto-generated method stub
		List<M> list = getDao().findObjectsByPage(qm);
		qm.getPageModel().setRows(list);
		return qm.getPageModel();
	}
}

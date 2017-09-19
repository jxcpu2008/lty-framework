package com.lty.framework.core.dao;

import java.util.List;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface BaseDAO<M, QM> {

	public int deleteByPrimaryKey(String id);

	public int insert(M record);

	public int insertSelective(M record);

	public M selectByPrimaryKey(String id);

	public int updateByPrimaryKeySelective(M record);

	public int updateByPrimaryKey(M record);

	public List<M> findObjectsByPage(QM record);
}

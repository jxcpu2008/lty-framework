package com.lty.framework.common.facade;

/**
 * 
 * @描述: 
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface BaseManagerFacadeI<M> {
	public int deleteByPrimaryKey(String id);

	public int insert(M record);

	public int insertSelective(M record);

	public int updateByPrimaryKeySelective(M record);

	public int updateByPrimaryKey(M record);

}

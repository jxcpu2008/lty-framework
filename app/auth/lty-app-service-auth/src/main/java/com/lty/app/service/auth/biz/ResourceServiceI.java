package com.lty.app.service.auth.biz;

import java.util.List;

import com.lty.app.facade.auth.model.Resource;
import com.lty.app.facade.auth.vo.ResourceQueryModel;
import com.lty.framework.core.service.BaseServiceI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public interface ResourceServiceI extends BaseServiceI<Resource, ResourceQueryModel> {
	public Resource findResourceByProperties(Resource r);

	public List<Resource> findAllTreeNode();

	public List<Resource> treegrid();

	public int remove(String id);

	public int add(Resource r);

	public int edit(Resource r);

}

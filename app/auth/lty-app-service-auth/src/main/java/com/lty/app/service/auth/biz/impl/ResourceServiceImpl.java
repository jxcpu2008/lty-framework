package com.lty.app.service.auth.biz.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lty.app.facade.auth.model.Resource;
import com.lty.app.facade.auth.vo.ResourceQueryModel;
import com.lty.app.service.auth.biz.ResourceServiceI;
import com.lty.app.service.auth.dao.ResourceMapper;
import com.lty.framework.core.dao.BaseDAO;
import com.lty.framework.core.service.BaseService;

/**
 * 
 * @描述: 
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@Service("resourceService")
public class ResourceServiceImpl extends BaseService<Resource, ResourceQueryModel> implements ResourceServiceI {
	@javax.annotation.Resource
	private ResourceMapper resourceMapper;

	@SuppressWarnings("rawtypes")
	@Override
	public BaseDAO getDao() {
		// TODO Auto-generated method stub
		return resourceMapper;
	}

	@Override
	public Resource findResourceByProperties(Resource r) {
		// TODO Auto-generated method stub
		return resourceMapper.findResourceByProperties(r);
	}

	@Override
	public List<Resource> findAllTreeNode() {
		List<Resource> l = makeResourceTree();
		return l;
	}

	private List<Resource> makeResourceTree() {
		ResourceQueryModel rm = new ResourceQueryModel();
		rm.setRows(10000);
		List<Resource> l = resourceMapper.findObjectsByPage(rm);
		if (l != null && l.size() > 0) {
			for (Resource r : l) {

				if (!StringUtils.isEmpty(r.getPid())) {
					Resource pm = resourceMapper.selectByPrimaryKey(r.getPid());// 获得当前节点的父节点对象
					if (pm != null) {
						r.setPid(pm.getId());
						r.setPname(pm.getText());
					}

				}
			}
		}
		return l;
	}

	@Override
	public List<Resource> treegrid() {
		List<Resource> l = makeResourceTree();
		return l;
	}

	@Override
	public int remove(String id) {
		if (!StringUtils.isEmpty(id))
			return resourceMapper.remove(id);
		return 0;
	}

	@Override
	public int add(Resource r) {
		if (StringUtils.isEmpty(r.getId())) {
			r.setId(UUID.randomUUID().toString());
		}
		return resourceMapper.insertSelective(r);
	}

	@Override
	public int edit(Resource r) {
		if (StringUtils.isEmpty(r.getId()))
			return 0;

		return resourceMapper.updateByPrimaryKeySelective(r);
	}

}

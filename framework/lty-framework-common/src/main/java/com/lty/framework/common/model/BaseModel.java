package com.lty.framework.common.model;

import com.lty.framework.common.page.Page;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class BaseModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8798649912230503305L;

	@SuppressWarnings("rawtypes")
	private Page pageModel = new Page();// 这个属性名字不能改，改了反射工具类名字也要相应的改

	private String sort;// 排序的字段
	private String order;// 排序的方式
	private int rows;// 一页显示多少行

	private int page;// 第几页

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		this.pageModel.setNowPage(page);
	}

	public String getSort() {
		return sort;
	}

	@SuppressWarnings("rawtypes")
	public Page getPageModel() {
		return pageModel;
	}

	@SuppressWarnings("rawtypes")
	public void setPageModel(Page pageModel) {
		this.pageModel = pageModel;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
		this.pageModel.setPageShow(rows);
	}

}

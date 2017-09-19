package com.lty.framework.common.page;

import java.util.Collections;
import java.util.List;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@SuppressWarnings("serial")
public class Page<E> implements java.io.Serializable {

	private int pageShow = 20;
	@SuppressWarnings("unused")
	private int totalPage;
	private int total;
	private int start;
	private int nowPage;
	private List<E> rows = Collections.emptyList();

	public int getStart() {
		start = (getNowPage() - 1) * getPageShow();
		if (start < 0) {
			start = 0;
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageShow() {
		return pageShow;
	}

	public void setPageShow(int pageShow) {
		this.pageShow = pageShow;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<E> getRows() {
		return rows;
	}

	public void setRows(List<E> rows) {
		this.rows = rows;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalPage() {
		return (int) Math.ceil(total * 1.0 / pageShow);
	}

	public int getNowPage() {
		if (nowPage <= 0)
			nowPage = 1;
		if (nowPage > getTotalPage())
			nowPage = getTotalPage();
		return nowPage;
	}

	@Override
	public String toString() {
		return "Page [pageShow=" + pageShow + ", totalPage=" + getTotalPage() + ", totalCount=" + total + ", nowPage="
				+ nowPage + ", result=" + rows + "]";
	}

}
/**
 * 
 */
package com.lty.framework.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @描述: 检测该用户所属的角色，是否有对所访问资源进行对应操作的权限。如果没有权限则终止后续操作
 * 如api/user/接口的增、删、改、查权限
 * @作者: Kevin Xie
 * @创建时间: 2016年10月12日
 * @版本: 1.0
 */
public class PermissionPolicy implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO 检测该用户所属的角色，是否有对所访问资源进行对应操作的权限的实现逻辑，暂时未实现

		System.out.println("======= 检测该用户所属的角色，是否有对所访问资源进行对应操作的权限的实现逻辑 ========");
		chain.doFilter(request, response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}

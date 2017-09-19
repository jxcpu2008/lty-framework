package com.lty.app.web.auth.controller.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lty.app.facade.auth.model.User;
import com.lty.app.facade.auth.service.UserQueryFacadeI;
import com.lty.app.facade.auth.vo.UserQueryModel;
import com.lty.framework.common.page.Page;

@Controller
@RequestMapping("/haha")
public class MyController {
	
	@Resource
	private UserQueryFacadeI userQueryFacade;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() throws Exception {
		System.err.println("##################");
		return "/user/hello";
	}
	
	@RequestMapping(value = "/hello.json", method = RequestMethod.GET)
	@ResponseBody
	public String hello2() throws Exception {
		System.err.println("$$$$$$$$$$$$$$$$$$");
		return "/user/hello";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String listUser(UserQueryModel uqm, ModelMap map) throws Exception {
		Page<User> data = userQueryFacade.findUserAndRoles(uqm);
		map.addAttribute("page", data);
		return "/user/page";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/userList1", method = RequestMethod.GET)
	public String listUser1(UserQueryModel uqm, ModelMap map) throws Exception {
		Page<User> data = userQueryFacade.findUserAndRoles(uqm);
		map.addAttribute("userList", data);
		return "/user/pageftl";
	}
}
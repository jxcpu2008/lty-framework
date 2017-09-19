package com.lty.utils.scan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lty.utils.scan.annotation.ScanAnnotation;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@ScanAnnotation(id = "yhgl", modelName = "yongh", description = "quanxian")
@Controller
@RequestMapping("/tc/dd")
public class TestControll {

	@RequestMapping(value = "")
	public void testM() {
		System.out.println("----------test.do-----------");
	}

}

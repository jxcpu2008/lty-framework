package com.lty.utils.scan.handler;

import java.util.List;
import java.util.Map;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class SampleHander implements HanlderI {

	public void excute(Map<String, List<String>> map) {

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {

			for (String url : entry.getValue()) {

				System.out.println("key= " + entry.getKey() + " and value= " + url);
			}

		}

	}

}

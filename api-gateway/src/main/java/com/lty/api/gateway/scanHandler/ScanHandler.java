package com.lty.api.gateway.scanHandler;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lty.utils.scan.handler.HanlderI;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class ScanHandler implements HanlderI {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ScanHandler.class);

	@Override
	public void excute(Map<String, List<String>> map) {
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {

			for (String url : entry.getValue()) {
				System.out.println("key= " + entry.getKey() + " and value= " + url);
			}

		}

	}
}

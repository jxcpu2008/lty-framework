package com.lty.framework.common.util;

import java.util.ResourceBundle;

/**
 * 
 * @描述: 项目参数工具类
 * @作者: Kevin Xie
 * @创建时间: 2016年10月8日
 * @版本: 1.0
 */
public class ResourceUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("config");

	private ResourceUtil() {

	}

	/**
	 * 
	 * @功能：获得sessionInfo名字
	 * 
	 * @param context
	 *
	 * @返回：String
	 */
	public static final String getSessionInfoName() {
		return bundle.getString("sessionInfoName");
	}

	/**
	 * 
	 * @功能：获得上传表单域的名称
	 * 
	 * @param context
	 *
	 * @返回：String
	 */
	public static final String getUploadFieldName() {
		return bundle.getString("uploadFieldName");
	}

	/**
	 * 
	 * @功能：获得上传文件的最大大小限制
	 * 
	 * @param context
	 *
	 * @返回：long
	 */
	public static final long getUploadFileMaxSize() {
		return Long.valueOf(bundle.getString("uploadFileMaxSize"));
	}

	/**
	 * 
	 * @功能：获得允许上传文件的扩展名
	 * 
	 * @param context
	 *
	 * @返回：String
	 */
	public static final String getUploadFileExts() {
		return bundle.getString("uploadFileExts");
	}

	/**
	 * 
	 * @功能：获得上传文件要放到那个目录
	 * 
	 * @param context
	 *
	 * @返回：String
	 */
	public static final String getUploadDirectory() {
		return bundle.getString("uploadDirectory");
	}

	/**
	 * 
	 * @功能：获得订单详细文件名
	 * 
	 * @param context
	 *
	 * @返回：String
	 */
	public static final String downloadDirectoryOrderDetailFile() {
		return bundle.getString("downloadDirectoryOrderDetailFile");
	}

	/**
	 * 
	 * @功能：获得要创建的文件目录
	 * 
	 * @param context
	 *
	 * @返回：String
	 */
	public static final String orderDetailFileDirectory() {
		return bundle.getString("downLoadFileDirectory");
	}

	/**
	 * 
	 * @功能：获得销量汇总【自然箱】文件名
	 * 
	 * @param context
	 *
	 * @返回：String
	 */
	public static final String downloadDirectoryOrderSumFile() {
		return bundle.getString("downloadDirectoryOrderSumFile");
	}

	/**
	 * 
	 * @功能：获取加密的盐字符串
	 * 
	 * @param context
	 *
	 * @返回：String
	 */
	public static final String getSalt() {
		return bundle.getString("salt");
	}
}

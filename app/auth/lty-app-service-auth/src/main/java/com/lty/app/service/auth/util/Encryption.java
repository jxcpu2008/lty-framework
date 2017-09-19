package com.lty.app.service.auth.util;

import org.apache.shiro.crypto.hash.Sha256Hash;

import com.lty.app.facade.auth.constant.EncryptConstant;

/**
 * 
 * @描述: 加密工具类
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class Encryption {

	/**
	 * 
	 * @功能：sha加密
	 * 
	 * @param password
	 *            待加密的明文
	 *
	 * @返回：String 加密后的密文
	 */
	public static String Sha256Hash(String password) {

		return new Sha256Hash(password, EncryptConstant.ENCRYPT_SALT, EncryptConstant.SALT_NUMS).toBase64();
	}
}

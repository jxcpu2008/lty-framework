package com.lty.framework.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @描述: 加密工具类 - md5加密出来的长度是32位;sha加密出来的长度是40位
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public final class Encrypt {

	/**
	 * 
	 * @功能：MD5加密
	 * 
	 * @param inputText
	 *            明文
	 * @return String 密文
	 */
	public static String encrypt(String inputText) {

		return md5(inputText);
	}

	/**
	 * 
	 * @功能：md5加密
	 * 
	 * @param inputText
	 * @return String
	 */
	public static String md5(String inputText) {

		return encrypt(inputText, "md5");
	}

	/**
	 * 
	 * @功能：二次加密 - 用sha再次加密md5的密文
	 * 
	 * @param inputText
	 *            明文
	 * @return String 密文
	 */
	public static String md5AndSha(String inputText) {

		return sha(md5(inputText));
	}

	/**
	 * sha加密
	 * 
	 * @param inputText
	 * @return
	 */
	public static String sha(String inputText) {

		return encrypt(inputText, "sha-1");
	}

	/**
	 * 
	 * @功能：md5或者sha-1加密
	 * 
	 * @param inputText
	 *            要加密的内容
	 * @param algorithmName
	 *            加密算法名称：md5或者sha-1，不区分大小写
	 * @return String 加密后的内容
	 */
	private static String encrypt(String inputText, String algorithmName) {

		if (inputText == null || "".equals(inputText.trim())) {

			throw new IllegalArgumentException("请输入要加密的内容");
		}

		if (algorithmName == null || "".equals(algorithmName.trim())) {

			algorithmName = "md5";
		}

		String encryptText = null;
		try {

			MessageDigest m = MessageDigest.getInstance(algorithmName);
			m.update(inputText.getBytes("UTF8"));
			byte s[] = m.digest();
			// m.digest(inputText.getBytes("UTF8"));
			return hex(s);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		return encryptText;
	}

	/**
	 * 
	 * @功能：返回十六进制字符串
	 * 
	 * @param arr
	 * @return String
	 */
	private static String hex(byte[] arr) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {

			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}

		return sb.toString();
	}

}

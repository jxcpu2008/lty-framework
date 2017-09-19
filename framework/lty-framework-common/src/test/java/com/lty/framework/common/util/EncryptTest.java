/**
 * 
 */
package com.lty.framework.common.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class EncryptTest {

	/**
	 * Test method for
	 * {@link com.lty.framework.common.util.Encrypt#encrypt(java.lang.String)}.
	 */
	@Test
	public void testEncrypt() {

		String encryStr = Encrypt.encrypt("Aa123456");
		assertEquals("afdd0b4ad2ec172c586e2150770fbf9e", encryStr);

	}

	/**
	 * Test method for
	 * {@link com.lty.framework.common.util.Encrypt#md5(java.lang.String)}.
	 */
	@Test
	public void testMd5() {

		String encryStr = Encrypt.md5("kevin.xie");
		assertEquals("2478429cabfb75fff5bb17686778fd7c", encryStr);
	}

	/**
	 * Test method for
	 * {@link com.lty.framework.common.util.Encrypt#md5AndSha(java.lang.String)}.
	 */
	@Test
	public void testMd5AndSha() {

		String encryStr = Encrypt.sha(Encrypt.md5("kevin.xie"));
		assertEquals("e8460cec92d167c9a8258686457e46de9dba7242", encryStr);
	}

	/**
	 * Test method for
	 * {@link com.lty.framework.common.util.Encrypt#sha(java.lang.String)}.
	 */
	@Test
	public void testSha() {

		String encryStr = Encrypt.sha(Encrypt.md5("kevin.xie123"));
		assertEquals("7d4cc5276eaeb83e5c801fa5f3b2f5b313aa46a3", encryStr);
	}

}

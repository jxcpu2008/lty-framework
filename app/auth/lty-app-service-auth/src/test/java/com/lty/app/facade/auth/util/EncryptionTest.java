/**
 * 
 */
package com.lty.app.facade.auth.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lty.app.service.auth.util.Encryption;

/**
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class EncryptionTest {

	/**
	 * Test method for
	 * {@link com.lty.app.facade.auth.util.Encryption#Sha256Hash(java.lang.String)}.
	 */
	@Test
	public final void testSha256Hash() {

		String encryStr = Encryption.Sha256Hash("3a960464d36c1b8bad183ed57ee79c0e39953cce");
		assertEquals("Icx6ZENJOCCqdQOCq/+s87dhl2ulL3m97m0b61iZAQE=", encryStr);
	}

}

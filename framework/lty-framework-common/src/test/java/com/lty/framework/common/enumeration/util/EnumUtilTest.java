package com.lty.framework.common.enumeration.util;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.lty.framework.common.enumeration.type.UserStatus;
import com.lty.framework.common.enumeration.type.UserType;
import com.lty.framework.common.util.EnumUtil;

public class EnumUtilTest {

	@Test
	public void printJsonStr() {
		List<Map<String, Object>> userTypes = EnumUtil.getValueList(UserType.class);
		List<Map<String, Object>> userStatus = EnumUtil.getValueList(UserStatus.class);
		System.out.println(JSON.toJSONString(userTypes));
		System.out.println(JSON.toJSONString(userStatus));
		
		List<Map<String, Object>> userTypes1 = EnumUtil.convertToList(UserType.class);
		List<Map<String, Object>> userStatus1 = EnumUtil.convertToList(UserStatus.class);
		System.out.println(JSON.toJSONString(userTypes1));
		System.out.println(JSON.toJSONString(userStatus1));
		
//		List<UserType> types = EnumUtils.getEnumList(UserType.class);
//		List<UserStatus> status = EnumUtils.getEnumList(UserStatus.class);
//		System.out.println(JSON.toJSONString(types));
//		System.out.println(JSON.toJSONString(status));
//		
//		Map<String, UserType> typeMap = EnumUtils.getEnumMap(UserType.class);
//		Map<String, UserStatus> statusMap = EnumUtils.getEnumMap(UserStatus.class);
//		System.out.println(JSON.toJSONString(typeMap));
//		System.out.println(JSON.toJSONString(statusMap));
	}
}

package com.lty.framework.common.enumeration.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lty.framework.common.enumeration.type.UserType;

public class FastJsonTest {

	@Test
	public void generateJsonStr() {
		
		// 覆盖枚举的toString方法
		System.out.println(JSON.toJSONString(UserType.SUPER_ADMIN));
		
		// 提供SerializeConfig
		SerializeConfig config = new SerializeConfig();
		config.createJavaBeanSerializer(UserType.class);
//		config.put(UserType.class, new EnumSerializer());
		String jsonStr = JSON.toJSONString(UserType.SUPER_ADMIN, config);
		System.out.println(jsonStr);
		
		String jsonStr1 = JSON.toJSONString(UserType.SUPER_ADMIN, SerializerFeature.WriteEnumUsingToString);
		System.out.println(jsonStr1);
		
		UserType[] values = UserType.values();
        List<UserType> userTypes = new ArrayList<UserType>();
        for (UserType value : values) {
        	System.out.println("value.name()=" + value.name());
        	userTypes.add(value);
        }
        System.out.println(JSON.toJSONString(userTypes, SerializerFeature.WriteEnumUsingToString));
	
        UserType[] values1 = UserType.values();
        List<Map> userTypes1 = new ArrayList<Map>();
        Field[] fields = UserType.class.getFields();
        for (UserType userType : values1) {
        	Map item = new HashMap();
        	item.put("value", userType.value());
        	item.put("desc", userType.desc());
        	userTypes1.add(item);
        }
        System.out.println(JSON.toJSONString(userTypes1));
	}
	
	@Test
	public void enumReflect() {
		Field[] fields = UserType.class.getFields();
		
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		
		Method[] methods = UserType.class.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
}

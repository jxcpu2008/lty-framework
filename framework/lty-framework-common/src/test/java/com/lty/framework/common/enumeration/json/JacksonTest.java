package com.lty.framework.common.enumeration.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.lty.framework.common.enumeration.type.UserType;

public class JacksonTest {

	@Test
	public void generateJsonStr() throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();  
	    String jsonStr = objectMapper.writeValueAsString(UserType.SUPER_ADMIN);
		System.out.println(jsonStr);
		
//		// 提供SerializeConfig
//		SerializeConfig config = new SerializeConfig();
//		config.createJavaBeanSerializer(UserType.class);
////		config.put(UserType.class, new EnumSerializer());
//		String jsonStr = JSON.toJSONString(UserType.SUPER_ADMIN, config);
//		System.out.println(jsonStr);
//		
//		String jsonStr1 = JSON.toJSONString(UserType.SUPER_ADMIN, SerializerFeature.WriteEnumUsingToString);
//		System.out.println(jsonStr1);
//		
//		UserType[] values = UserType.values();
//        List<UserType> userTypes = new ArrayList<UserType>();
//        for (UserType value : values) {
//        	userTypes.add(value);
//        }
//        System.out.println(JSON.toJSONString(userTypes, SerializerFeature.WriteEnumUsingToString));
	}
	
//	@Test
//	public void enumReflect() {
//		Field[] fields = UserType.class.getFields();
//		
//		for (Field field : fields) {
//			System.out.println(field.getName());
//		}
//	}
}

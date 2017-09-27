package com.lty.framework.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.reflect.MethodUtils;

import com.lty.framework.common.enumeration.EnumDisplay;

public class EnumUtil {

	/**
	 * 
	 * 获取指定枚举类型所有常量的字段值列表
	 * 使用枚举类型的values方法
	 * 需要实现指定的接口
	 *
	 * @param ref
	 * @return
	 */
	public static List<Map<String, Object>> convertToList(Class<? extends EnumDisplay> ref) {
		if (ref == null) {
			return null;
		}
		
		if (ref.isEnum()) {
			List<Map<String, Object>> enums = new ArrayList<Map<String, Object>>();
			
			try {
				Method method = ref.getMethod("values");
				EnumDisplay[] values = (EnumDisplay[]) method.invoke(ref);
				if (values != null) {
					for (EnumDisplay type : values) {
			        	Map<String, Object> item = new HashMap<String, Object>();
			        	item.put("value", type.value());
			        	item.put("desc", type.desc());
			        	
			        	enums.add(item);
			        }
					
					return enums;
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		return null;
	}
	
	/**
	 * 
	 * 获取指定枚举类型所有常量的字段值列表
	 * 使用枚举类型的getEnumConstants方法
	 * 
	 * @param ref
	 * @return java.util.List
	 */
	public static <T> List<Map<String, Object>> getValueList(Class<T> ref) {
		if (ref == null) {
			return null;
		}
		
		if (ref.isEnum()) {
			List<Map<String, Object>> enums = new ArrayList<Map<String, Object>>();
			
			T[] ts = ref.getEnumConstants();
			for (T t : ts) {
				Map<String, Object> item = new HashMap<String, Object>();
                Enum<?> tempEnum = (Enum<?>) t;
                
                Integer value = (Integer) getInvokeValue(t, "value");
                if (value == null) {  
                	value = Integer.valueOf(tempEnum.ordinal());
                }
                item.put("value", value);
                
                String desc = (String) getInvokeValue(t, "desc");
                if (desc == null) {  
                	desc = (String) tempEnum.name();
                }
                
                item.put("desc", desc);
                
                enums.add(item);
            }
			
			return enums;
		}
		
		return null;
	}
	
	static <T> Object getInvokeValue(T t, String methodName) {
        try {
            Method method = MethodUtils.getAccessibleMethod(t.getClass() , methodName);
            return method.invoke(t);
        } catch (Exception e) {
            return null;
        }
    }
}

package com.lty.framework.common.enumeration.type;

import com.lty.framework.common.enumeration.EnumDisplay;

public enum UserType implements EnumDisplay {

	SUPER_ADMIN(0, "超级管理员"),
	ADMIN(1, "管理员"),
	USER(2, "普通用户");
	
	private final int value;
	private final String desc;
	
	UserType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	@Override
	public int value() {
		// TODO Auto-generated method stub
		return getValue();
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return getDesc();
	}

	public static UserType valueOf(int value) {
		if (value < 0 || value >= values().length) {
            throw new IllegalArgumentException("参数错误！");
        }
		
		int ordinal = 0;
		UserType rtnValue = null;
		for (UserType userType : values()) {
			if (userType.value() == value) {
				rtnValue = values()[ordinal];
				break;
			}
			ordinal++;
		}
		return rtnValue;
    }

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return value() + "-" + desc();
//	}

	// for json
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"value\":" + value() + ",\"desc\":" + "\"" + desc() + "\"}";
	}
}

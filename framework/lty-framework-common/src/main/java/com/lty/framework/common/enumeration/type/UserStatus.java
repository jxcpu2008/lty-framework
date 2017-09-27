package com.lty.framework.common.enumeration.type;

import com.lty.framework.common.enumeration.EnumDisplay;

public enum UserStatus implements EnumDisplay {

	NORMAL(1, "正常"),
	LOCK(0, "锁定"),
	DELETE(2, "删除");
	
	private final int value;
	private final String desc;
	
	UserStatus(int value, String desc) {
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

	public static UserStatus valueOf(int value) {
		if (value < 0 || value >= values().length) {
            throw new IllegalArgumentException("参数错误！");
        }
		
		int ordinal = 0;
		UserStatus rtnValue = null;
		for (UserStatus userStatus : values()) {
			if (userStatus.value() == value) {
				rtnValue = values()[ordinal];
				break;
			}
			ordinal++;
		}
		return rtnValue;
    }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value() + "-" + desc();
	}
}

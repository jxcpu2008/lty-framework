package com.lty.framework.common.enumeration.type;

public enum UserType {

	SUPER_ADMIN(0, "超级管理员"),
	ADMIN(1, "管理员"),
	USER(2, "普通用户");
	
	private final int type;
	private final String desc;
	
	UserType(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public int type() {
		return type;
	}

	public String desc() {
		return desc;
	}
	
	public static UserType valueOf(int value) {
		if (value < 0 || value >= values().length) {
            throw new IllegalArgumentException("参数错误！");
        }
		
		int ordinal = 0;
		UserType rtnValue = null;
		for (UserType userType : values()) {
			if (userType.type() == value) {
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
		return type() + "-" + desc();
	}
}

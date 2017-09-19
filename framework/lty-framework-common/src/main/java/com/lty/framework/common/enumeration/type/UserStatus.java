package com.lty.framework.common.enumeration.type;

public enum UserStatus {

	NORMAL(1, "正常"),
	LOCK(0, "锁定"),
	DELETE(2, "删除");
	
	private final int state;
	private final String value;
	
	UserStatus(int state, String value) {
		this.state = state;
		this.value = value;
	}

	public int state() {
		return state;
	}

	public String value() {
		return value;
	}
	
	public static UserStatus valueOf(int value) {
		if (value < 0 || value >= values().length) {
            throw new IllegalArgumentException("参数错误！");
        }
		
		int ordinal = 0;
		UserStatus rtnValue = null;
		for (UserStatus userStatus : values()) {
			if (userStatus.state() == value) {
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
		return state() + "-" + value();
	}
}

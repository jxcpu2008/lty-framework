package com.lty.app.web.auth.message;

public interface Message<T> {

	public T deserialize(byte[] data);
	
	public byte[] serialize(T t);
}

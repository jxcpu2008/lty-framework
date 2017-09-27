package com.lty.app.web.auth.message.biz;

import com.google.protobuf.InvalidProtocolBufferException;
import com.lty.app.web.auth.message.Message;
import com.lty.app.web.auth.message.biz.entity.PersonEntity;
import com.lty.app.web.auth.message.biz.entity.PersonEntity.Person;

public class PersonMessage implements Message<PersonEntity.Person> {
	
	@Override
	public PersonEntity.Person deserialize(byte[] data) {
		// TODO Auto-generated method stub
		if (data == null || data.length == 0) {
			return null;
		}
		
		try {
			return Person.parseFrom(data);
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public byte[] serialize(PersonEntity.Person person) {
		// TODO Auto-generated method stub
		if (person == null) {
			return null;
		}
		
		return person.toByteArray();
	}
}

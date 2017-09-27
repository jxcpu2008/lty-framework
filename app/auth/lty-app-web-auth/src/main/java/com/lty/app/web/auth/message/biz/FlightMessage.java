package com.lty.app.web.auth.message.biz;

import com.google.protobuf.InvalidProtocolBufferException;
import com.lty.app.web.auth.message.Message;
import com.lty.app.web.auth.message.biz.entity.FlightEntity;
import com.lty.app.web.auth.message.biz.entity.FlightEntity.Flight;

public class FlightMessage implements Message<FlightEntity.Flight> {
	
	@Override
	public FlightEntity.Flight deserialize(byte[] data) {
		// TODO Auto-generated method stub
		if (data == null || data.length == 0) {
			return null;
		}
		
		try {
			return Flight.parseFrom(data);
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public byte[] serialize(FlightEntity.Flight flight) {
		// TODO Auto-generated method stub
		if (flight == null) {
			return null;
		}
		
		return flight.toByteArray();
	}
}

package com.trip.utils;

import java.util.UUID;

public class UUIDTools {
	public static String getUUID(){
		UUID str = UUID.randomUUID();
		String uuid=str.toString().replace("-", "");
		return uuid;
	}
}

package com.utility;

import com.google.gson.Gson;

public class TestUtility {
	
	public static String convertPOJOToJson(Object object) {
		
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
		
	}

}

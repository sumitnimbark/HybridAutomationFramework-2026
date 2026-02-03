package com.api.tests;

import com.google.gson.Gson;
import com.pojo.AddOrderPOJO;

import io.restassured.RestAssured;

public class AddOrder {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://petstore.swagger.io/";
		
		AddOrderPOJO order1 = new AddOrderPOJO(1, 1, 2, "2024-06-10T14:12:10.123Z", true);
		
		Gson gson = new Gson();
		String orderJson = gson.toJson(order1);
		
		RestAssured
			.given()
				.header("Content-Type", "application/json")
				.and()
				.body(orderJson)
				.log().all()
			
			.when()
				.post("v2/store/order")
			
			.then()
				.assertThat()
				.statusCode(200)
				.log().all();

	}

}

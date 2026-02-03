package com.api.tests;

import io.restassured.RestAssured;

public class FindPetById {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://petstore.swagger.io/";
		
		RestAssured
			.given()
				.header("accept", "application/json")
				.and()
				.pathParams("petId", "1")
				.log().all()
			
			.when()
				.get("v2/pet/{petId}")
			
			.then()
				.assertThat()
				.statusCode(200)
				.log().all();
	}

}
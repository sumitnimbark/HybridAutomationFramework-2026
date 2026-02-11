package com.api.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FindPetById {
	
	@BeforeMethod
	public void setup()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/";
	}
	
	@Test(description = "Find Pet by ID", groups = {"API"})
	public void FindPetByIdTest() {
		
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
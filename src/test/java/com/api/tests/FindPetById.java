package com.api.tests;

import static com.utility.TestUtility.readConfigFile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Env;

import static io.restassured.RestAssured.*;

public class FindPetById {
	
	@BeforeMethod
	public void setup()
	{
		baseURI = readConfigFile(Env.QA, "BASE_URL");
		//RestAssured.baseURI = "https://petstore.swagger.io/";
	}
	
	@Test(description = "Find Pet by ID", groups = {"API"})
	public void FindPetByIdTest() {
		
			given()
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
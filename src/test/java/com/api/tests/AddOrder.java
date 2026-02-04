package com.api.tests;

import com.pojo.AddOrderPOJO;

import static com.utility.TestUtility.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AddOrder {
	
	AddOrderPOJO order1;
	
	@BeforeMethod
	public void setup()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/";
		order1 = new AddOrderPOJO(1, 1, 2, "2024-06-10T14:12:10.123Z", true);
	}

	@Test(description = "Add Order to the Store", groups = {"API"})
	public void addOrder() {
		
		RestAssured
			.given()
				.header("Content-Type", "application/json")
			.and()
				.body(convertPOJOToJson(order1))
				.log().all()
			
			.when()
				.post("v2/store/order")
			
			.then()
				.assertThat()
				.statusCode(200)
				.log().all();

	}

}

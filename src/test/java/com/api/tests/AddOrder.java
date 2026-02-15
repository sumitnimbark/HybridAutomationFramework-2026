package com.api.tests;

import com.constants.Env;
import com.pojo.AddOrderPOJO;

import static com.utility.TestUtility.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class AddOrder {
	
	AddOrderPOJO order1;
	
	@BeforeMethod
	public void setup()
	{
		baseURI = readConfigFile(Env.QA, "BASE_URL");
		//RestAssured.baseURI = "https://petstore.swagger.io/";
		order1 = new AddOrderPOJO(1, 1, 2, "2024-06-10T14:12:10.123Z", true);
	}

	@Test(description = "Add Order to the Store", groups = {"API"}, retryAnalyzer = com.listeners.ReExecuteFailedTestListener.class)
	public void addOrder() {
		
			 given()
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

package Queryparameters;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Cookies {
	
	@Test(priority=1)
	public void testCookiesAPI()
	{
		
		given()
		
		.when()
		.get("https://google.co.in")
		
		.then()
		.cookie("AEC")
		.statusCode(200)
		.log().all();

	}

}

package Queryparameters;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


//http://localhost:3000/students?page=1&Id=3

public class Qparameters {
	@Test
	public void testQueryParameters()
	{
	
		 given()
		 .pathParam("mypath","students") //path param
		 .queryParam("page", 1) //Query param
		 .queryParam("id", 2) //queryparam
		 
		 
		 .when()
		.delete("http://localhost:3000/{mypath}")
		 //.get("https://reqres.in/api/{mypath}")
		 
		 .then()
		.statusCode(404)
		
		.log().all();
	}

//	@Test(priority=2)
	
	public void testDeleteuser()
	{
		
		given()
		
		.when()
		.delete("http://localhost:3000/{mypath}")
		
		.then()
		.log().all();
		
		
	}
}

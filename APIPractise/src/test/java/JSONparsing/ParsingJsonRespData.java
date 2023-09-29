package JSONparsing;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ParsingJsonRespData {
	@Test(priority=1)
	void testJsonResponse()
	{
		given()
		
		.contentType("ContentType.JSON")
			
		.when()
		.get("http://localhost:3000/students")
		
		.then()
		//x[2].id
		.statusCode(200)
		//.body("x[2].id",equalTo(3))
		.body("x[1].gender",equalTo("male"));
	
				
		
		
		
	}

}

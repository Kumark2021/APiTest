package Post;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostWays {
	
	//Using HashMap
//	@Test(priority=1)
	public void usingPostHashMap()
	{
		HashMap data=new HashMap();
		
		data.put("fName", "Kiran");
		data.put("lName", "Kumar");
		data.put("gender", "male");
		data.put("age", "40");
		String addressArr[]= {"101","Bollineni","Chennai"};
		data.put("address", addressArr);
		
		given()
		
				.contentType("application/json")
				.body(data)
		
		.when()
		
		  .post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("fName",equalTo("Kiran"))
		.body("lName",equalTo("Kumar"))
		.body("gender",equalTo("male"))
		.body("age",equalTo("40"))
		//.body("address[0]","101")
		
		.body("address[0]",equalTo("101"))
		.body("addressr[1]", equalTo("Bollienini"))
		.body("addressr[2]", equalTo("Chennai"))
		.header("Content-Type","application/json;charset=utf-8")
		.log().all();
		
		

		
				
		
		
	}

	@Test(priority=1)
	public void usingJsonLibrary()
	{
		JSONObject data= new JSONObject();
		data.put("fName", "Kiran");
		data.put("lName", "Kumar");
		data.put("gender", "male");
		data.put("age", "40");
		String addressArr[]= {"101","Bollineni","Chennai"};
		data.put("address", addressArr);
		
		given()
		
				.contentType("application/json")
				.body(data.toString())
		
		.when()
		
		  .post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("fName",equalTo("Kiran"))
		.body("lName",equalTo("Kumar"))
		.body("gender",equalTo("male"))
		.body("age",equalTo("40"))
		//.body("address[0]","101")
		
		.body("address[0]",equalTo("101"))
		.body("addressr[1]", equalTo("Bollineni"))
		.body("addressr[2]", equalTo("Chennai"))
		.header("Content-Type","application/json;charset=utf-8")
		.log().all();
		
		

		
				
		
		
	}
}

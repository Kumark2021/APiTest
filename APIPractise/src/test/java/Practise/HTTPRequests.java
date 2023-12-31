package Practise;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests {
	int id;
	@Test(priority=1)
	
	void getUsers()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.log().all();
		  	
			
		
	}
	@Test(priority=2)
	
	void createUser()
	{ 
		HashMap data =new HashMap();
		data.put("name","Kiran");
		data.put("job","Leader");
		
		id=given()
		
		 .contentType("application/jsom")
		.body(data)
		
		.when()
		
		 .post("https://reqres.in/api/users")
		 .jsonPath().getInt("id");
		 
		 
		 //.then()
		 //.statusCode(200);
		
		
		
	}
	
	@Test(priority=3)
	
	void updateUser()
	{
		HashMap data =new HashMap();
		data.put("name","Kiran");
		data.put("job","Senior Leader");
		
		
	  given()
		
		.contentType("application/json")
		.body(data)
		
		.when()
		
		 .put("https://reqres.in/api/users"+id)
		// .jsonPath().getInt("id")
		 
		 
		 .then()
		 .statusCode(200)
		 .log().all()      ;
	  
		
		
	}
@Test(priority=4)
	
	void deleteUsers()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users"+id)
		
		.then()
			.statusCode(204)
			.log().all();
		  	
			
		
	}
	

}

package Pojo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class Using_Pojo {
	
	//@Test(priority=1)
	
	public void usingPostHashMap()
	{
		Pojoimple data=new Pojoimple();
		data.setfName("Sourya");
		data.setlName("Sahasra");
		data.setGender("male");
		data.setAge("10");
		String addArr[]= {"101","bollineni","Chennai"};
				
		data.setAddress(addArr);
		
		
		
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
	
	public void usingfile() throws FileNotFoundException
	{
		/*Pojoimple data=new Pojoimple();
		data.setfName("Sourya");
		data.setlName("Sahasra");
		data.setGender("male");
		data.setAge("10");
		String addArr[]= {"101","bollineni","Chennai"};
				
		data.setAddress(addArr);*/
		
		File f =new File(".\\test.json");
		FileReader fr= new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		
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
		.body("addressr[1]", equalTo("Bollienini"))
		.body("addressr[2]", equalTo("Chennai"))
		.header("Content-Type","application/json;charset=utf-8")
		.log().all();		
				
			}
	
	@Test(priority=2)
	
	public void deleteUser()
	{
		
		given()
		
		.when()
		.delete("http://localhost:3000/students")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}

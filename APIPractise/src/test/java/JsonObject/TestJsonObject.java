package JsonObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestJsonObject {

	@Test(priority=1)
	void testJSONObject()
	{
		
		
		Response res= given()
				.contentType(ContentType.JSON)
			//	.contentType("application/JSON")
				
				
				.when()
				.get("http://localhost:3000/students");
				
				//Using JSONObject class
				JSONObject jo = new JSONObject(res.asString());
				
				//Print all the countries code
				boolean status=false;
				for (int i=0;i<jo.getJSONArray("students").length();i++)
				{
					String codeage=jo.getJSONArray("students").getJSONObject(i).get("age").toString();
					//System.out.print(codeage);
					if (codeage.equals(40))
					{
						status=true;
					}
					
				}
				
				
				
	
	
	
	
	}

}

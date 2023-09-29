package XMLAPI;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.xml.*;            
import io.restassured.response.Response;


public class ParsingXMLReponse {
	
	//@Test(priority=1)
	
	public void testXML()
	{
		//Approach 1
		/*given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page",equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));*/
		
		
		Response res=
				given()
				
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
				Assert.assertEquals(res.getStatusCode(),200);
				Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
				String pageno=res.xmlPath().get("TravelerinformationResponse.page").toString();
				Assert.assertEquals(pageno, "1");
				String name=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
				Assert.assertEquals(name, "Developer");
				res.statusLine();
				res.prettyPrint();
	}

	@Test(priority=1)
	
	
		public void XmlResposebody()
		{
		Response res=
				given()
				
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xp= new XmlPath(res.asString());
		List<String> info=xp.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(info.size(), 10);
		List<String> name=xp.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status=false;
		for (String trname:name)
		{
			//System.out.println(trname);
			
			if (trname.equals("Developer"))
			{
				status=true;
				break;
			}
		}
		Assert.assertEquals(status, true);
		}
	
}

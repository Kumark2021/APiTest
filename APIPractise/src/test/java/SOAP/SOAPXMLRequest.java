package SOAP;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;

import static io.restassured.RestAssured.*;



public class SOAPXMLRequest {
	@Test(priority=1)
	public void validateXML()
	{
		File f=new File("./SOAPXMLFile/add.xml");
		
		FileInputStream fis =new FileInputStream(f);
		
		String requestBody=IOUtils.toString(fis,"UTF-8");          
		
	baseURI="http://www.dneonline.com/";
	given().
		contentType("text/xml").accept(ContentType.XML).
		
	
	}

}

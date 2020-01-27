package Products;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Helpers.Base;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Products_Get_Id extends Base{
public static Response respid;

	public Products_Get_Id() throws IOException {
		super();
	}

	@BeforeSuite
	public void setup() throws InterruptedException
	{
		RestAssured.baseURI="http://localhost:3030/products/";
		RequestSpecification httprequest =RestAssured.given();
		respid =httprequest.request(Method.GET,"43900");
		System.out.println("Testcase Products_get_Id Started");
		Thread.sleep(3000);
	}
	@Test(priority = 1,description = "Validate_Response")
	public void Validate_Get_products_Response_TC01() throws InterruptedException 
	{
				String Response_json = respid.getBody().asString();
				System.out.println(" Response Body is: "+Response_json);	
				Thread.sleep(2000);
	}
	
	@Test(priority =2, description = "Validate status code")
	public void Products_Get_Id_StatusCode_TC02()
	{
		int Statuscode = respid.getStatusCode();
		System.out.println("Status code : "+Statuscode);
		assertEquals(Statuscode, HttpStatus.SC_OK);
	}
	
	@Test(priority =3, description = "Validate Status Line")
	public void Products_Get_Id_StatusLine_TC03()
	{
		String Statusline = respid.getStatusLine();
		System.out.println("Status Line : "+Statusline);
		assertEquals(Statusline, "HTTP/1.1 200 OK");
	}
	
	@Test(priority =4, description = "Validate Headers")
	public void Products_Get_Id_Headers_TC04()
	{
		Headers headers=respid.getHeaders();
		System.out.println("Headers are : " +headers);
		assertEquals(headers.getValue("ETag"), "W/\"448-HK+7FOWwXWiupzaUDo7jVkmRXqo\"");
	}
	
	@Test(priority =5, description = "Validate Response time")
	public void Products_Get_Id_ResponseTime_TC05()
	{
		long Responsetime = respid.getTime();
		System.out.println("Response Time is: "+Responsetime);
	}
	
	@Test(priority =6, description = "",enabled = false)
	public void IntendToFailProducts_Get_Id_Response_TC06()
	{
		String Json= respid.getBody().toString();
		System.out.println("Response : "  +Json);
	}
	
	@Test(priority =7, description = "validate status code")
	public void IntendToFailProducts_Get_Id_StatusCode_TC07()
	{
		int Statuscode = respid.getStatusCode();
		System.out.println("Status code : "+Statuscode);
		assertEquals(Statuscode,HttpStatus.SC_CREATED);
	}
	
	@Test(priority =8, description = "validate status line")
	public void IntendToFailProducts_Get_Id_StatusLine_TC08()
	{
		String Statusline = respid.getStatusLine();
		System.out.println("Status Line : "+Statusline);
		assertEquals(Statusline, "HTTP/1.1 201 OK");
	}
	
	@Test(priority =9, description = "validate headers")
	public void IntendToFailProducts_Get_Id_Headers_TC09()
	{
		Headers headers=respid.getHeaders();
		System.out.println("Headers are : " +headers);
		assertEquals(headers.getValue("ETag"), "wwW/\"448-HK+7FOWwXWiupzaUDo7jVkmRXqo\"");
	}
	
	@Test(priority =10, description = "validate response",enabled = false)
	public void IntendToFailProducts_Get_Id_ResponseTime_TC10()
	{
		long Responsetime = respid.getTime();
		System.out.println("Response Time is: "+Responsetime);
	}
	@AfterSuite
	public void teardown()
	{
		System.out.println("Testcase Products_get_Id Finished");
	}
}

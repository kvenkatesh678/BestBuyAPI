package Products;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Helpers.Base;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Products_Get extends Base {

	public static Response resp;
	public Products_Get() throws IOException {
		super();
	}
	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		RestAssured.baseURI= "http://localhost:3030";
		RequestSpecification httprequest= RestAssured.given();
		resp = httprequest.request(Method.GET,"/products");
		Thread.sleep(3000);
	}
	
	@Test(priority = 2,description = "Validate_Get_StatusCode",groups = {"Regression"})
	public void  Validate_Get_products_StatusCode_TC01()
	{
		int Scode = resp.getStatusCode();
		System.out.println("Status Code is: "+Scode);
		assertEquals(Scode, HttpStatus.SC_OK);
	}
	
	@Test(priority = 1,description = "Validate_Response")
	public void Validate_Get_products_Response_TC02() throws InterruptedException 
	{
				String Response_json = resp.getBody().asString();
				System.out.println(" Response Body is: "+Response_json);	
	}
	
	@Test(priority = 3,description = "Validate_StatusLine")
	public void  Validate_Get_products_StatusLine_TC03()
	{
		String Sline = resp.getStatusLine();
		System.out.println("Status Line is: "+Sline);
		assertEquals(Sline, "HTTP/1.1 200 OK");
	}
	
	@Test(priority = 4,description = "Validate_Get_products_Response_time_TC04")
	public void Validate_Get_products_Response_time_TC04()
	{
		long Response_time =  resp.getTime();
		System.out.println("Response time :" +Response_time );
		if(Response_time>10000)
		{
			System.out.println("Resposne is :" +Response_time);
			assertEquals(Response_time, "10000");
		}
		
	}
	
	@Test(priority = 5,description = "Validate_Response_Headers")
	public void Validate_Get_products_Response_Headers_TC05()
	{
		Headers headers =  resp.getHeaders();
		System.out.println("Headers are :" +headers );
		assertEquals(headers.getValue("Content-Type"), "application/json; charset=utf-8");
		assertEquals(headers.getValue("Content-Encoding"), "gzip");
		assertEquals(headers.getValue("Transfer-Encoding"), "chunked");
	}
	
	@Test(priority = 6,description = "Intend to Validate_Get_StatusCode")
	public void  IntendToFail_Get_products_StatusCode_TC06()
	{
		int Scode = resp.getStatusCode();
		System.out.println("Status code is: "+Scode);
		assertEquals(Scode, HttpStatus.SC_CREATED,"Data Miss Matched");
	}
	
	@Test(priority = 7,description = "Validate_StatusLine")
	public void  IntendToFail_Get_products_StatusLine_TC07()
	{
		String Sline = resp.getStatusLine();
		System.out.println("Status Line is: "+Sline);
		assertEquals(Sline, "HTTP/1.1 201 OK","Data Miss Matched");
	}
	
	@Test(priority = 8,description = "Validate_Response_Headers")
	public void IntendToFail_Get_products_Response_Headers_TC08()
	{
		Headers headers =  resp.getHeaders();
		System.out.println("Headers are :" +headers );
		assertEquals(headers.getValue("Content-Encoding"), "gzip");
		assertEquals(headers.getValue("Transfer-Encoding"), "chunkedd","Data Miss Matched");
	}
}

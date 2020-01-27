package Products;

import static org.testng.Assert.assertEquals;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Products_Delete {
public static  Response del;
	@BeforeSuite
	public void setup() throws InterruptedException
	{
		RestAssured.baseURI="http://localhost:3030/products/";
		 RequestSpecification httprequest = RestAssured.given();
		 del = httprequest.request(Method.DELETE,"9999678");
		 System.out.println("Test");
		 Thread.sleep(2000);
	}
	
	@Test(description = " validate response")
	public void Products_Delete_TC01()
	{
		String Json= del.getBody().asString();
		System.out.println("Response is: "+Json);
	}
	@Test(description = " validate response_code")
	public void Products_Delete_response_code_TC02()
	{
		int scode= del.getStatusCode();
		System.out.println("Response is: "+scode);
		assertEquals(scode, HttpStatus.SC_OK);
	}

	@Test(description = " validate response_time")
	public void Products_Delete_response_time_TC03()
	{
		long rtime= del.getTime();
		System.out.println("Response is: "+rtime);
	}
}

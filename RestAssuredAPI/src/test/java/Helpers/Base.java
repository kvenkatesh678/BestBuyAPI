package Helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base{

public static String path = System.getProperty("user.dir")+"/RestAssuredAPI/src/test/java/Helpers/config.properties";
public static String file= "C:/Users/user/eclipse-workspace/RestAssuredAPI/src/test/java/Helpers/config.properties";
public static Properties prop;

	public Base() throws IOException
	{
		try {
			prop = new Properties();
			FileInputStream fi = new FileInputStream(file);
			prop.load(fi);
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
			e.printStackTrace();
		}
		
	}
	
	
	
}

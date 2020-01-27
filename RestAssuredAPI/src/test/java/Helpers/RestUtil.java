package Helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {

	//*********** products ***************
	public static String name() {
		String name =RandomStringUtils.randomAlphanumeric(5);
		return name;
	}
	
	public static String type() {
		String type =RandomStringUtils.randomAlphanumeric(2);
		return "Android"+type;
	}
	
	public static String price() {
		String price =RandomStringUtils.random(5);
		return price;
	}
	
	public static String shipping() {
		String shipping =RandomStringUtils.random(5);
		return shipping;
	}
	
	public static String upc() {
		String upc =RandomStringUtils.randomAlphanumeric(3);
		return upc;
	}
	
	public static String description() {
		String description =RandomStringUtils.randomAlphanumeric(6);
		return description+" "+description;
	}
	
	public static String manfacturer() {
		String manfacturer =RandomStringUtils.randomAlphabetic(1);
		return "samsung"+manfacturer;
	}
	
	public static String model() {
		String model =RandomStringUtils.randomNumeric(4);
		return "samsung"+model;
	}
	
	public static String url() {
		String url =RandomStringUtils.randomAlphanumeric(8);
		return "www."+url+"@gmail.com";
	}
	
	public static String image() {
		String image =RandomStringUtils.randomAlphabetic(5);
		return image+".png";
	}
	
	//******************* end ************************************
	
	//****************** Stores *****************************************
	
	public static String address()
	{
		String address= RandomStringUtils.randomAlphabetic(6);
		return address;
	}
	
	public static String address2()
	{
		String address2= RandomStringUtils.randomAlphabetic(6);
		return address2;
	}
	
	public static String city()
	{
		String city= RandomStringUtils.randomAlphabetic(8);
		return city;
	}
	
	public static String state()
	{
		String state= RandomStringUtils.randomAlphabetic(10);
		return state;
	}
	
	public static String zip()
	{
		String zip= RandomStringUtils.randomNumeric(6);
		return zip;
	}

	public static String lat()
	{
		String lat= RandomStringUtils.randomNumeric(2);
		return lat+"."+lat;
	}
	
	public static String lan()
	{
		String lan= RandomStringUtils.randomNumeric(2);
		return lan+"."+lan;
	}
	public static String hours()
	{
		String hours= RandomStringUtils.randomAlphabetic(10);
		return hours;
	}
	
	public static String Services()
	{
		String Services= RandomStringUtils.randomAlphabetic(4);
		return "Always@"+Services;
	}
	//************** end  ***************************************
	
}


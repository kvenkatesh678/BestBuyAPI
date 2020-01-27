package Helpers;

import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil implements Serializable {
	public static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
	}
	
	public static String JavaToJsonConverter(Object object)
	{
		String jsoncode="";
		try {
			jsoncode=mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			System.out.println("failure occured while converting from java to json" +e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("failure occured while converting from java to json" +e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("failure occured while converting from java to json" +e.getMessage());
			e.printStackTrace();
		}
		return jsoncode;	
	}
	
	public static <T> T JsonToJavaConverter(String Jsonstring, Class<T> cls)
	{
		T result=null;
		try {
			result = mapper.readValue(Jsonstring, cls);
		} catch (JsonParseException e) {
			System.out.println("failure occured while converting from json to java" +e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("failure occured while converting from json to java" +e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("failure occured while converting from json to java" +e.getMessage());
			e.printStackTrace();
		}
		return result;
		
	}
}



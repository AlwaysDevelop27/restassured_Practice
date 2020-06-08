package apiPackage;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POSTMethod {
	
	@Test
	public void postMethod(){
		RestAssured.baseURI = "http://localhost:3000/";
		
		RequestSpecification httprequest = RestAssured.given();
		
		
		Map<String, Object> mapval = new HashMap<String, Object>();
		
		mapval.put("EmployeeId", "5");
		mapval.put("FirstName", "Nishal");
		mapval.put("LastName", "Jev");
		mapval.put("Desgination", "Tester");
		mapval.put("DOB", "27Aug1989");
		mapval.put("Martial status", "Male");
		
		System.out.println(mapval);
		
		JSONObject request1 = new JSONObject(mapval);
		
		httprequest.header("Content-Type","application/json");
		
		//convert to jsonstring
		httprequest.body(request1.toString());
	
		
		Response response = httprequest.request(Method.POST,"/employee");
		
		String responsebody = response.getBody().asString();
		System.out.println("response body: "+responsebody);
		
		
	}

}

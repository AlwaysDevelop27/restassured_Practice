package apiValidationPkg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POSTReq {
	
	@Test
	public void postWeatherDetails(){
		
		//Base uri
		RestAssured.baseURI = "http://localhost:3000";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//send req in form of key and value
		//request payload sending along with post request
		JSONObject requestParam = new JSONObject();
		requestParam.put("title", "Nikkish");
		requestParam.put("author", "Nishu123");
		//requestParam.put("id", "9");
		
		//requestParam.put("email", "nishu@yahoo.com");
		
		
				
		
		//content-type
		httprequest.header("Content-Type","application/json");
		
		//convert to jsonstring
		httprequest.body(requestParam.toString());
		
		//response object
		Response response = httprequest.request(Method.POST,"/posts");
		
		//RESPONSE BODY
		String responsebody = response.getBody().asString();
		System.out.println("response body "+responsebody);
		
		int status_code = response.getStatusCode();
		System.out.println("status code "+status_code);
		
	}

}

package apiValidationPkg;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_PUTReq {
	
	@Test
	public void putRequestData(){
		
		//base uri
		RestAssured.baseURI = "http://localhost:3000";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//request payload
		JSONObject requestParam = new JSONObject();
		requestParam.put("id", "4");
		requestParam.put("title", "Nikki");
		requestParam.put("author", "Nikki hunt");
		
		//content-type
		httprequest.header("Content-Type","application/json");
				
		//convert to jsonstring
		httprequest.body(requestParam.toJSONString());
				
		//response object
		Response response = httprequest.request(Method.PUT,"/posts/4");
		
		int status_code = response.getStatusCode();
		System.out.println("status code: "+status_code);
		
		String responsebody = response.body().asString();
		System.out.println("response body: "+responsebody);
		
		
	}

}

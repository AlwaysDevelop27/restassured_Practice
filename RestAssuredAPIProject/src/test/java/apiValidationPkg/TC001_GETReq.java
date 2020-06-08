package apiValidationPkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GETReq {
	
	@Test
	public void getWeatherDetails(){
		
		//SPECIFY URI
		RestAssured.baseURI = "http://localhost:3000";
		
		//REQUEST OBJECT
		RequestSpecification httprequest = RestAssured.given();
	
		//response object
		Response response = httprequest.request(Method.GET,"/posts");
		
		//body of response 
		System.out.println("response of server: "+response.getBody().asString());
		
		//status code validation
		int status_code = response.getStatusCode();
		System.out.println("Status code: "+status_code);
		Assert.assertEquals(200, status_code);
		
		//status line validation
		String status_line = response.getStatusLine();
		System.out.println("status line: "+status_line);
		
		
		
	}

}

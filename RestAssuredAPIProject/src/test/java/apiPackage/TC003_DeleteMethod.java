package apiPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_DeleteMethod {
	
	@Test
	public void deleteMethod(){
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.DELETE,"/employee/4");
		
		String responsebody = response.getBody().asString();
		
		System.out.println("response body: "+responsebody);
		
		int statuscode = response.getStatusCode();
		
		System.out.println("staus code: "+statuscode);
	}

}

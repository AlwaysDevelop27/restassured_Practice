package apiValidationPkg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_DELETEReq {
	@Test
	public void deleteData(){
		
		//base uri
		RestAssured.baseURI = "http://localhost:3000";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//content header
		
		//httprequest.head("Content-type", "application/json");
		
		//respnse call
		Response response = httprequest.request(Method.DELETE,"/posts/3");
		
		int status_code = response.getStatusCode();
		System.out.println("status code: "+status_code);
		
		String responsebody = response.body().asString();
		System.out.println("response body: "+responsebody);
	}

}

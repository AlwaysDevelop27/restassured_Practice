package apiPackage;
//import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_PUTMethod {
	
	@Test
	public void putMethod(){
		
		RestAssured.baseURI = "http://localhost:3000/";
		
		RequestSpecification httprequest = RestAssured.given();
		
		
		JSONObject mapval = new JSONObject();
		
		mapval.put("id", 4);
		mapval.put("EmployeeId", "5");
		mapval.put("FirstName", "Daksh");
		mapval.put("LastName", "Jev");
		mapval.put("Desgination", "Tester");
		mapval.put("DOB", "28Sep1990");
		mapval.put("Martial status", "Male");
		
		/*given().put("http://localhost:3000/employee/5")
		.then().statusCode(200).log().all();*/
		
		Response response = httprequest.request(Method.PUT,"/employee");
		String responsebody = response.getBody().asString();
		System.out.println("response body: "+responsebody);

		
		
		
		
		
		
	}
	

}

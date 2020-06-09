package apiPackage;
//import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_PUTMethod {
	
	@DataProvider(name = "getData")
	public Object[][] data1(){
		Object[][] data = new Object[1][6];
		
		data[0][0] = 6;
		data[0][1] ="Nandu";
		data[0][2] ="Devansh";
		data[0][3] ="HR";
		data[0][4] ="25Aug1985";
		data[0][5] ="Married";
		
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void putMethod(Object EmployeeId,Object FirstName,Object LastName,Object Desgination,Object DOB,Object Martial_status){
		
		RestAssured.baseURI = "http://localhost:3000/";
		
		RequestSpecification httprequest = RestAssured.given();
		
		
		JSONObject mapval = new JSONObject();
		
		mapval.put("id", 8);
		mapval.put("EmployeeId", EmployeeId);
		mapval.put("FirstName", FirstName);
		mapval.put("LastName", LastName);
		mapval.put("Desgination", Desgination);
		mapval.put("DOB", DOB);
		mapval.put("Martial status", Martial_status);
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(mapval.toJSONString());
		Response response = httprequest.put("/employees/8");
				
				/*request(Method.,"/employees/4");*/
		String responsebody = response.getBody().asString();
		System.out.println("response body: "+responsebody);

		
		
		
		
		
		
	}
	

}

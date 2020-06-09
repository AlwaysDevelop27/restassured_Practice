package apiPackage;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POSTMethod {
	
	@DataProvider(name= "DataToRead")
	public Object[][] readData(){
		
		Object [][] data = new Object[1][6];
		
		data[0][0] = 6;
		data[0][1] ="Nandu";
		data[0][2] ="Deva";
		data[0][3] ="HR";
		data[0][4] ="25Aug1980";
		data[0][5] ="Married";
		
		return data;
	}
	
	@Test(dataProvider ="DataToRead")
	public void postMethod(Object EmployeeId,Object FirstName,Object LastName,Object Desgination,Object DOB,Object Martial_status){
		RestAssured.baseURI = "http://localhost:3000/";
		
		RequestSpecification httprequest = RestAssured.given();
		
		
		Map<String, Object> mapval = new HashMap<String, Object>();
		
		System.out.println("value: "+Martial_status);
		mapval.put("EmployeeId", EmployeeId);
		mapval.put("FirstName", FirstName);
		mapval.put("LastName", LastName);
		mapval.put("Desgination", Desgination);
		mapval.put("DOB", DOB);
		mapval.put("Martial_status",Martial_status);
		
		System.out.println(mapval);
		
		JSONObject request1 = new JSONObject(mapval);
		
		httprequest.header("Content-Type","application/json");
		
		//convert to jsonstring
		httprequest.body(request1.toString());
	
		
		Response response = httprequest.request(Method.POST,"/employees");
		
		String responsebody = response.getBody().asString();
		System.out.println("response body: "+responsebody);
		
		
	}

}

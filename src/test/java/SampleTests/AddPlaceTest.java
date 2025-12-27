package SampleTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;
import files.reusableMethod;

public class AddPlaceTest {

	/* public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.addPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).header("Server", "Apache/2.4.52 (Ubuntu)").body("scope", equalTo("APP"));

	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.addPlace())
		.when().post("maps/api/place/add/json")
		.then().extract().response().asString();
		
		System.out.println(response);
		JsonPath js=reusableMethod.rawTojson(response); //Extract useful info by reading data step by step using JSON path class
		String place_id= js.getString("place_id");
		System.out.println("Place_id is "+place_id);
		
		String newAddress="17 Battery Place,Newyork 10004 USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\": \""+place_id+"\",\r\n"
				+ "    \"address\": \""+newAddress+"\",\r\n"
				+ "    \"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		String getPlaceDetails=given().log().all().queryParam("key","qaclick123").queryParam("place_id",place_id)
		.when().get("maps/api/place/get/json")
		.then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1=reusableMethod.rawTojson(getPlaceDetails);
		String actualAddress=js1.get("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress,newAddress); //its a testng asssertion method
		
		
	}

}

package SampleTests;

import static io.restassured.RestAssured.*;



import java.util.Arrays;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import pojo.AddPlaceResponse;
import pojo.Location;
import pojo.PlaceDetails;

public class SpecBuilder {

    public static void main(String[] args) {
    	

        PlaceDetails place = new PlaceDetails();
        place.setAccuracy(65);
        place.setName("Sunrise Heights Apartments");
        place.setPhone_number("(+91) 912 345 6789");
        place.setAddress("12, Linking Road, Bandra West, Mumbai");
        place.setTypes(Arrays.asList("apartment", "residential"));
        place.setWebsite("https://sunriseheights.in");
        place.setLanguage("English-IN");

        Location loc = new Location();
        loc.setLat(19.076090);
        loc.setLng(72.877426);
        place.setLocation(loc);
        
    	RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Content-Type", "application/json")
				.addQueryParam("key","qaclick123")
				.build();

    	ResponseSpecification res = new ResponseSpecBuilder().expectContentType("application/json")
				.expectStatusCode(200)
				.build();

        RequestSpecification req_spec =
            given()
            	.spec(req).body(place).log().all();
        
        Response res_spec = 
        		req_spec.when().post("/maps/api/place/add/json")
        		.then().spec(res).extract().response();
        
        String resString=res_spec.asString();
        System.out.println(resString);

    }
}

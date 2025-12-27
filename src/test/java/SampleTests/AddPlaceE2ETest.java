package SampleTests;
import static io.restassured.RestAssured.*;



import java.util.Arrays;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import pojo.AddPlaceResponse;
import pojo.Location;
import pojo.PlaceDetails;

public class AddPlaceE2ETest {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        PlaceDetails place = new PlaceDetails();
        place.setAccuracy(80);
        place.setName("Green Valley Residency");
        place.setPhone_number("(+91) 987 654 3210");
        place.setAddress("45, MG Road, Near Metro Station, Bangalore");
        place.setTypes(Arrays.asList("apartment", "residential"));
        place.setWebsite("https://jsoneditoronline.org/");
        place.setLanguage("Kannada");

        Location loc = new Location();
        loc.setLat(12.9715987);
        loc.setLng(77.5945627);
        place.setLocation(loc);

        AddPlaceResponse res =
            given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(place)
            .when()
                .post("/maps/api/place/add/json")
            .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().as(AddPlaceResponse.class);

        System.out.println("Status   : " + res.getStatus());
        System.out.println("Place ID : " + res.getPlace_id());
    }
}
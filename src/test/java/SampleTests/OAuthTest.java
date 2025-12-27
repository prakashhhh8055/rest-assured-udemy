package SampleTests;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.CourseDetails;
import pojo.api;
import pojo.webAutomation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import files.reusableMethod;

public class OAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] courseTitle= {"Selenium Webdriver Java","Cypress","Protractor"};
		String respons1=given()
			.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
			.formParams("grant_type","client_credentials")
			.formParams("scope","trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		System.out.println(respons1);
		JsonPath js=new JsonPath(respons1);
		String AccessToken=js.getString("access_token");
	
		CourseDetails rs=given()
			.queryParam("access_token",AccessToken)
			.when().log().all()
			.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(CourseDetails.class);
		System.out.println(rs.getLinkedIn());
		System.out.println(rs.getInstructor());
		
		System.out.println(rs.getCourses().getApi().get(0).getCourseTitle());
		System.out.println(rs.getCourses().getApi().get(0).getPrice());
		
		List<api> apiCourse=rs.getCourses().getApi();
		
		for(int i=0;i<apiCourse.size();i++)
		{
			System.out.println(apiCourse.get(i).getCourseTitle());
		}
		
		
		List<webAutomation> WebAutomation=rs.getCourses().getWebAutomation();
		//One Way
		for(int i=0;i<WebAutomation.size();i++)
		{
			if(WebAutomation.get(i).getCourseTitle().equalsIgnoreCase("Cypress"))
			{
				System.out.println(WebAutomation.get(i).getPrice());
				break;
			}
		}
		
		ArrayList<String> a=new ArrayList();
		
		//Another Way
		for(int j=0;j<WebAutomation.size();j++)
		{
			a.add(WebAutomation.get(j).getCourseTitle());
		}
		
		
		List<String> expectedOutput=Arrays.asList(courseTitle); // Converting String Array into String List
		Assert.assertTrue(a.equals(expectedOutput));
			

	}

}

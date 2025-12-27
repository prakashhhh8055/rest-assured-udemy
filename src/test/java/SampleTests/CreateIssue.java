package SampleTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateIssue {
	
	public static void main(String[] args) {
	
	RestAssured.baseURI = "https://prakashgirishmalagi.atlassian.net";
	
	String CreateIssueResponse=given()
	.header("Content-Type","application/json")
	.header("Authorization","Basic cHJha2FzaGdpcmlzaG1hbGFnaUBnbWFpbC5jb206QVRBVFQzeEZmR0YwYXpLdjV1Mjl3d1RyYlpkanlhY0JsWVZSXzVvdjAwYVd2dTJFcElxNWkzVWRfNXZLVmZPZ1ozNzNpeGJNNWhkenlJOHZhVTlBcFltTHVFekhnR1lrZzZLT2dPbU9XRE9rTFBOVTJhQ0xka1F0dUVtXzhUNUs4NF9jLXptR2RyNHhPdWtuTFhhUUFEVG9PaVUyV0xBT281b252SHB3d01YNVc0VmJvV1VnSU1nPUI5RDE1NTdG")
	.body("{\r\n"
			+ "    \"fields\": {\r\n"
			+ "        \"project\": {\r\n"
			+ "            \"key\": \"SCRUM\"\r\n"
			+ "        },\r\n"
			+ "        \"summary\": \"Jira Issue Created on jira using Rest Apis\",\r\n"
			+ "        \"issuetype\": {\r\n"
			+ "            \"name\": \"Bug\"\r\n"
			+ "        },\r\n"
			+ "        \"description\": {\r\n"
			+ "            \"type\": \"doc\",\r\n"
			+ "            \"version\": 1,\r\n"
			+ "            \"content\": [\r\n"
			+ "                {\r\n"
			+ "                    \"type\": \"paragraph\",\r\n"
			+ "                    \"content\": [\r\n"
			+ "                        {\r\n"
			+ "                            \"type\": \"text\",\r\n"
			+ "                            \"text\": \"Issue Created on jira using Rest Apis\"\r\n"
			+ "                        }\r\n"
			+ "                    ]\r\n"
			+ "                }\r\n"
			+ "            ]\r\n"
			+ "        }\r\n"
			+ "    }\r\n"
			+ "}\r\n"
			+ "")
	.post("/rest/api/3/issue")
	.then().log().all().assertThat().statusCode(201)
	.extract().response().asString();
	
	JsonPath jp=new JsonPath(CreateIssueResponse);
	String ID=jp.get("id");
	System.out.println("Jira Ticket ID is "+ID);
	
	given()
	.pathParam("key",ID)
	.header("Authorization","Basic cHJha2FzaGdpcmlzaG1hbGFnaUBnbWFpbC5jb206QVRBVFQzeEZmR0YwYXpLdjV1Mjl3d1RyYlpkanlhY0JsWVZSXzVvdjAwYVd2dTJFcElxNWkzVWRfNXZLVmZPZ1ozNzNpeGJNNWhkenlJOHZhVTlBcFltTHVFekhnR1lrZzZLT2dPbU9XRE9rTFBOVTJhQ0xka1F0dUVtXzhUNUs4NF9jLXptR2RyNHhPdWtuTFhhUUFEVG9PaVUyV0xBT281b252SHB3d01YNVc0VmJvV1VnSU1nPUI5RDE1NTdG")
	.header("X-Atlassian-Token","no-check")
	.multiPart("file",new File("/Users/3Embed/Downloads/Background.png")).log().all()
	.post("rest/api/3/issue/{key}/attachments")
	.then().log().all().assertThat().statusCode(200);
	
	
	
	}
	
}

package SampleTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;
import files.reusableMethod;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class dynamicJson {
	
	
	
	/*	public static void AddBook()
	{   
		//Add Book Action
		RestAssured.baseURI="http://216.10.245.166";
		String resp=given().header("Content-Type","application/json").body(payload.Addbookpayload("Oops","ops","999","Jagan"))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=reusableMethod.rawTojson(resp);
		String id=js.getString("ID");
		String msg=js.getString("Msg");
		System.out.println(id+" - "+msg);
		
		//Delete book Action
        String deletePayload = "{\r\n  \"ID\" : \"" + id + "\"\r\n}";
		String DeleteResp=given().header("Content-Type","application/json").body(deletePayload)
		.when().post("Library/DeleteBook.php")
		.then().extract().response().asString();
		System.out.println(DeleteResp);
	}  */
	
	@Test(dataProvider="Bookdata")
	public static void AddBook(String Bname,String isbn,String aisle,String AuthName)
	{   
		//Add Book Action
		RestAssured.baseURI="http://216.10.245.166";
		String resp=given().header("Content-Type","application/json").body(payload.Addbookpayload(Bname,isbn,aisle,AuthName))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=reusableMethod.rawTojson(resp);
		String id=js.getString("ID");
		String msg=js.getString("Msg");
		System.out.println(id+" - "+msg);
		
		// DELETE BOOK
	    String deletePayload = "{ \"ID\" : \"" + id + "\" }";
	    String deleteResp = given()
	            .header("Content-Type", "application/json")
	            .body(deletePayload)
	    .when()
	            .post("Library/DeleteBook.php")
	    .then()
	            .extract().response().asString();

	    System.out.println("Deleted: " + deleteResp);
	}
	
	@DataProvider(name="Bookdata")
	public Object[][] getData()
	{
		return new Object[][] {{"C Program","Cpgm","090","Edward John"},{"Python","pym","810","Steve Smith"},{"Database SQL","sql","322","Gurunath Singh"}};
	}
	


}

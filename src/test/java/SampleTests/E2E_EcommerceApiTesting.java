package SampleTests;

import io.restassured.builder.RequestSpecBuilder;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateOrderRequest;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.Order;

public class E2E_EcommerceApiTesting {

	public static void main(String[] args) {
		//Login
		RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		LoginRequest loginReq=new LoginRequest();
		loginReq.setUserEmail("Prakashgirishmalagi@gmail.com");
		loginReq.setUserPassword("Dboss@8055");
		
		LoginResponse res=given().log().all().spec(req).body(loginReq)
		.when().post("/api/ecom/auth/login")
		.then().log().all().extract().response().as(LoginResponse.class);
		
		String token=res.getToken();
		System.out.println("User Token is "+token);
		String UserId=res.getUserId();
		System.out.println("User ID is "+UserId);
		
		
		//Create product
		RequestSpecification createProductReq =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
												.addHeader("authorization",token)
												.build();
		
		Response CreateProductResponse = given().spec(createProductReq).param("productName","Classic Cotton Shirt")
									.param("productAddedBy",UserId)
									.param("productCategory","fashion")
									.param("productSubCategory","shirts")
									.param("productPrice","1550")
									.param("productDescription","A lightweight, breathable cotton shirt designed for everyday comfort with a clean casual wear.")
									.param("productFor","Men")
									.multiPart("productImage",new File("C:\\Users\\3Embed\\Downloads\\cottonshirt.png"))
													
									.when().post("/api/ecom/product/add-product")
													
									.then().log().all().extract().response();
		
		JsonPath js = CreateProductResponse.jsonPath();
		String ProductID = js.get("productId");
		String Message = js.get("message");
		System.out.println("Product ID is -> "+ProductID);
		System.out.println("Confirmation Msg Is -> "+Message);
		
		//Create Order
		RequestSpecification createOrderReq =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
											.addHeader("authorization",token).setContentType(ContentType.JSON)
											.build();
		
		Order order=new Order();
		order.setCountry("United States");
		order.setProductOrderedId(ProductID);
		
		List<Order> myorder=new ArrayList<Order>();
		myorder.add(order);
		
		CreateOrderRequest cor=new CreateOrderRequest();
		cor.setOrders(myorder);
	
		String CreateOrderResponse = given().spec(createOrderReq).body(cor).log().all()
		.when().post("/api/ecom/order/create-order")
		.then().log().all().extract().response().asString();
		
		JsonPath js1=new JsonPath(CreateOrderResponse);
		String OrderID=js1.get("orders[0]");
		System.out.println(OrderID);
		
		//Get Order Details
		RequestSpecification getOrderDetailsReq =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization",token)
				.build();
		
		String OrderDetailsRes= given().spec(getOrderDetailsReq).queryParam("id",OrderID)
		.when().get("/api/ecom/order/get-orders-details")
		.then().extract().response().asString();
		
		System.out.println(OrderDetailsRes);
		
		//Delete Product
		RequestSpecification DeleteProductReq =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization",token)
				.build();
		
		String DeleteProductRes = given().spec(DeleteProductReq).pathParam("productId",ProductID)
		.when().delete("/api/ecom/product/delete-product/{productId}")
		.then().log().all().extract().response().asString();
		System.out.println(DeleteProductRes);
		
		//Delete Order
		RequestSpecification DeleteOrderReq =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization",token)
				.build();
		
		String DeleteOrderRes = given().spec(DeleteProductReq).pathParam("orders",OrderID)
		.when().delete("/api/ecom/order/delete-order/{orders}")
		.then().log().all().extract().response().asString();
		System.out.println(DeleteOrderRes);
		
		
		
		
													
	}

}

package SampleTests;
import org.testng.annotations.*;

import files.payload;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class SumValidation {
	
	@Test
	public static void sumOfCourses()
	{
		int sum=0;
		JsonPath js=new JsonPath(payload.coursePrice());
		int count=js.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int total=price * copies;
			System.out.println(total);
			sum=sum+total;
		}
		System.out.println("Actual Purchase Total is = "+sum);
		
		int purchaseAmt=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum,purchaseAmt);
		
		
		
	}

}

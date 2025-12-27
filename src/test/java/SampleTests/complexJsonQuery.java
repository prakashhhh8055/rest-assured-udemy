package SampleTests;

import files.payload;
import io.restassured.path.json.JsonPath;

public class complexJsonQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		JsonPath js=new JsonPath(payload.coursePrice());
		int course_size=js.getInt("courses.size()");
		System.out.println("Course size is : "+course_size);
		
		int purchseAmt=js.getInt("dashboard.purchaseAmount");
		System.out.println("The purchase amount is : "+purchseAmt);
		
		String FirstTitleCounrse = js.getString("courses[0].title");
		System.out.println("Title of the First Course is : "+FirstTitleCounrse);
		
		//Print all the Course Titles and Prices
		for(int i=0;i<course_size;i++)
		{
			String Course_Title=js.getString("courses["+i+"].title");
			int Course_Price=js.getInt("courses["+i+"].price");
			System.out.println(Course_Title+" - "+Course_Price);

		}
		
		//Print No of copies sold by RPA
		for(int i=0;i<course_size;i++)
		{
			String Course_Title=js.getString("courses["+i+"].title");
			if(Course_Title.equalsIgnoreCase("RPA"))
			{
				System.out.println("No Of copies Sold by RPA -"+js.getInt("courses["+i+"].copies"));
				break;
			}
		}
		
	}

}

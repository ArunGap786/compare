package apicall;

import java.io.FileInputStream;
import static
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.opc.internal.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class getrequest {

	@Test
	public static String apigetcall()
	{
		RestAssured.baseURI= "https://samples.openweathermap.org";
		Response res=given().
		queryParam("q","London,UK").
		queryParam("appid","b1b15e88fa797225412429c1c50c122a1").
		when().
		get("/data/2.5/history/city?q=London,UK").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("pressure",equalTo("1011")).
		extract().response();
		// Task 2- Grab the Place ID from response
		
		String responseString=res.asString();
		System.out.println(responseString);
		JsonPath js= new JsonPath(responseString);
		String cod=js.get("cod");
		String city=js.get("city_id");
		String calctime=js.get("calctime");
		String cnt=js.get("cnt");
		String pressure=js.get("list.main[0].pressure");
		
	}
}
	

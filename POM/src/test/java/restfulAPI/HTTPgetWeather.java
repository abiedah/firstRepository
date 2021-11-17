package restfulAPI;

//import java.lang.reflect.Method;

//import org.openqa.selenium.remote.Response;
//import org.testng.annotations.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.specification.RequestSpecification;

//import com.sun.org.apache.bcel.internal.classfile.Method;

import static io.restassured.RestAssured.given; //needs to be imported
import static org.hamcrest.Matchers.*; //needs to be imported
import java.util.ArrayList;
import java.util.List;
//import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 
import java.util.ArrayList; 
import java.util.concurrent.TimeUnit; 
import static io.restassured.RestAssured.*; //needs to be imported

public class HTTPgetWeather {

	@Test
	public void GetWeatherDetails() {
		
//		Specify the base URL to the Restful web service
		RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";
		
//		Get the RequestSpecification of the request that you want to send to the server.
//		The server is specified by the BaseURL that we have specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		
//		Make a request to the server by specifying the method Type and the method URL.
//		This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET,"/Miami");
		
//		Now let us print the body of the message to see what response we have received from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is -> " + responseBody);
		
	}
	
	@Test
	public void GetWeatherDetails2() {
			
		RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Miami");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		String city = jsonPathEvaluator.getString("City");
		
		System.out.println("City received from Response " + city);
		
//		Get the status code from the Response. In case of a successful interaction with the web service, 
//		we should get a status code of 200.
		int statusCode = response.getStatusCode();
		
//		Assert that correct status code is returned
		Assert.assertEquals(statusCode/*actual value*/,200/* expected value*/, "Correct status code returned");
		
		
	}
	
	@Test
	public void VerifyCityInJSonResponse() {
		
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city"; 
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Miami");
		
//		First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		
//		Then simply query the JsonPath object to get a String value of the node
//		specified by JsonPath: City (Note: You should not put $. in the Java code)
		String city = jsonPathEvaluator.getString("City");
		
//		Let us print print the city variable to see what we got
		System.out.println("City received from Response " + city);
		
//		Validate the response
		Assert.assertEquals(city, "Miami", "Correct city name received in the Response");
	}
	
	
}

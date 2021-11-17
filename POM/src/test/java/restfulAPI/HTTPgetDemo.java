package restfulAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class HTTPgetDemo {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";  //the parameters using is posts
	}
	
	@Test
	public void getReponse() {
//		The HTTP GET request is used to fetch a resource from a server.
		Response response = given()
				.contentType(ContentType.JSON)
				.when()
				.get("/posts")
				.then()
				.extract().response();
		
		Assert.assertEquals(response.statusCode(),200);
//		String title = response.jsonPath().getString("title[:2]");
//		Assert.assertEquals(response.jsonPath().getString("title[:2]"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "qui est esse");
		System.out.printf("title[:2]"); // "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "qui est esse");
//		System.out.println(title);
	}	
	
	
	}
package restfulAPI;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class HTTPdemo {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	}
	
	@Test
	public void statusCode() {
		given().
		when().
			get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200);
	}
	
	@Test
	public void	pathtest() {		//check page equals to page 2
		given().
		when().
			get("https://reqres.in/api/users?page=2").
		then().
		assertThat().
		body("page",equalTo(2));
	}
	
	@Test
	public void testDataIDofData0() {
		given().
		when().
			get("https://reqres.in/api/users?page=2").
		then().
		assertThat().
		body("page", equalTo(2), "data[0].id", equalTo(7));
		
	}
	
	@Test
	public void testDataIDoffirstNameData5() {
		given().
		when().
			get("https://reqres.in/api/users?page=2").
		then().
		assertThat().
		body("page", equalTo(2), "data[5].first_name", equalTo("Rachel"));
	}
	
	@Test
	public void findLastElement() {
		given().
		when().
			get("https://reqres.in/api/users?page=2").
		then().
		assertThat().
		body("page", equalTo(2), "data[-1].id", equalTo(12));
	}
	
	@Test
	public void howManyDataElements() {
		given().
		when().
			get("https://reqres.in/api/users?page=2").
		then().
		assertThat().
		body("size()", equalTo(6));
	}
	
	@Test
	public void size() {
		given().
		when().
			get("https://pokeapi.co/api/v2/pokemon?limit=100&offset=200").
		then().
		assertThat().
		statusCode(200).
		body("results.size()", equalTo(100));  // if equalTo(4) - fail because the result size is 100
	}
	
	
	
	
}

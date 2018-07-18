package restAutomation;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gherkin.deps.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class APIAutomation {

	RequestSpecification httpRequest;
	//JSONObject requestPara;
	Gson gson = new Gson();

	@BeforeTest
	public void preConfig() {
		RestAssured.baseURI = "https://reqres.in/";
		httpRequest = RestAssured.given();
	}

	@Test(enabled = false)
	public void listUsers() {
		Response response = get("/api/users?page=2");
		System.out.println(response.getBody().asString());
	}

	@Test(enabled = false)
	public void singleUser() {
		Response response = get("/api/users/2");
		System.out.println(response.getBody().asString());
	}

	@Test
	public void create() {
		Response response = post("/api/users",
				new File("D:\\Workspace\\Incubation\\src\\test\\java\\restAutomation\\creatUser.json"));
		assertThat(response.statusCode(), is(201));
		System.out.println(response.getBody().prettyPrint());
	}

	@Test
	public void update() {
		Response response = post("/api/users",
				new File("D:\\Workspace\\Incubation\\src\\test\\java\\restAutomation\\update.json"));
		System.out.println(response.getBody().prettyPrint());
	}

	public Response get(String uri) {
		return httpRequest.request(Method.GET, uri);
	}

	public Response post(String uri, File payload) {
		httpRequest.body(payload);
		return httpRequest.post(uri);
	}

	public Response put(String uri, File payload) {
		httpRequest.body(payload).log().body();
		return httpRequest.post(uri);
	}
}
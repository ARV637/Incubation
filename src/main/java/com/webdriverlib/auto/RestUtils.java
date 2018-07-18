package com.webdriverlib.auto;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * 
 * @author Ashish_Vishnoi
 *
 */
public class RestUtils {
	private static String accessToken;

	public static void setAccessToken(String accessToken) {
		RestUtils.accessToken = accessToken;
	}

	/**
	 * Posts the data
	 * 
	 * @param url    provide valid URL
	 * @param appURL provide valid Application URL
	 * @param body   provide body
	 * @return API response
	 */
	public static Response postData(String url, String appURL, String body) {
		return RestAssured.given().header("Authorization", "bearer " + accessToken).header("App-Url", appURL)
				.header("Content-Type", "application/json").body(body).post(url);
	}

	/**
	 * Creates the data without payload
	 * 
	 * @param url    provide valid URL
	 * @param appURL provide valid Application URL
	 * @return API response
	 */
	public static Response postDataWithoutPayLoad(String url, String appURL) {
		return RestAssured.given().header("Authorization", "bearer " + accessToken).header("App-Url", appURL)
				.header("Content-Type", "application/json").post(url);
	}

	/**
	 * Creates the data without payload,appurl
	 * 
	 * @param url    provide valid URL
	 * @param appURL provide valid Application URL
	 * @return API response
	 */
	public static Response postDataWithoutPayLoadWithoutAppURL(String url) {
		return RestAssured.given().header("Authorization", "bearer " + accessToken)
				.header("Content-Type", "application/json").post(url);
	}

	/**
	 * Retrieves the response
	 * 
	 * @param url         provide valid URL
	 * @param appURL      provide valid Application URL
	 * @param accessToken provide access token
	 * @return API response
	 */
	public static Response get(String url, String appURL, String accessToken) {
		return RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "bearer " + accessToken).header("App-Url", appURL).get(url);
	}

	/**
	 * Retrieves the response
	 * 
	 * @param url    provide valid URL
	 * @param appURL provide valid app URL
	 * @return API response
	 */
	public static Response get(String url, String appURL) {
		return RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "bearer " + accessToken).header("App-Url", appURL).get(url);
	}

	/**
	 * Retrieves the response using Query
	 * 
	 * @param url    provide valid URL
	 * @param appURL provide valid app URL
	 * @param query  provide Query
	 * @return API response
	 */
	public static Response getWithQuery(String url, String appURL, String query) {
		return RestAssured.given().queryParam("query", query).header("Content-Type", "application/json")
				.header("Authorization", "bearer " + accessToken).header("App-Url", appURL).get(url);
	}

	/**
	 * Updates the existing resource
	 * 
	 * @param url    provide valid URL
	 * @param appURL provide valid app URL
	 * @param body   provide the body to be updated
	 * @return API response
	 */
	public static Response put(String url, String appURL, String body) {
		return RestAssured.given().header("Authorization", "bearer " + accessToken).header("App-Url", appURL)
				.header("Content-Type", "application/json").body(body).put(url);
	}

	/**
	 * deletes an entity
	 * 
	 * @param url    provide valid URL
	 * @param appURL provide valid app URL
	 * @return API response
	 */
	public static Response delete(String url, String appURL) {
		return RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "bearer " + accessToken).header("App-Url", appURL).delete(url);
	}

	/**
	 * Retrieves the response without App URL
	 * 
	 * @param url provide valid URL
	 * @return API response
	 */
	public static Response getWithoutAppURL(String url) {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addHeader("Content-Type", ContentType.JSON.toString());
		builder.addHeader("accept", ContentType.JSON.toString());
		builder.addHeader("Authorization", "Bearer " + accessToken);
		builder.log(LogDetail.ALL);
		RequestSpecification requestSpec = builder.build();
		return RestAssured.expect().given().spec(requestSpec).get(url);
	}

	/**
	 * Creates the data
	 * 
	 * @param url  provide valid URL
	 * @param body Provide the body
	 * @return API response
	 */
	public static Response postWithoutAppURL(String url, String body) {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addHeader("Content-Type", ContentType.JSON.toString());
		builder.addHeader("accept", ContentType.JSON.toString());
		builder.addHeader("Authorization", "Bearer " + accessToken);
		builder.setBody(body);
		builder.log(LogDetail.ALL);
		RequestSpecification requestSpec = builder.build();
		return RestAssured.expect().given().spec(requestSpec).post(url);
	}

	/**
	 * updates the data without App URL
	 * 
	 * @param url  provide valid URL
	 * @param body provide the body
	 * @return API response
	 */
	public static Response putWithoutAppURL(String url, String body) {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addHeader("Content-Type", ContentType.JSON.toString());
		builder.addHeader("accept", ContentType.JSON.toString());
		builder.addHeader("Authorization", "Bearer " + accessToken);
		builder.setBody(body);
		builder.log(LogDetail.ALL);
		RequestSpecification requestSpec = builder.build();
		return RestAssured.expect().given().spec(requestSpec).put(url);
	}

	/**
	 * deletes the data without App URL
	 * 
	 * @param url provide valid URL
	 * @return API response
	 */
	public static Response deleteWithoutAppURL(String url) {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addHeader("Content-Type", ContentType.JSON.toString());
		builder.addHeader("accept", ContentType.JSON.toString());
		builder.addHeader("Authorization", "Bearer " + accessToken);
		builder.log(LogDetail.ALL);
		RequestSpecification requestSpec = builder.build();
		return RestAssured.expect().given().spec(requestSpec).delete(url);
	}

}

package com.book;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBookDetails {
	@Test
	public void get(){
		System.out.println("get book details");
		RequestSpecification getRequest = RestAssured.given();
		
		Response res= getRequest.get("/book");
		res.prettyPrint();
		
		RequestSpecification postRequ = RestAssured.given();
		postRequ.header("Content-type", "Application/json");
		
		JsonObject book = new JsonObject();
		book.addProperty("title", "Java");
		book.addProperty("author", "Ravi");
		book.addProperty("price", 789.87);
		book.addProperty("category", "Engineering");
		
		postRequ.body(book.toString());
		Response postResp = postRequ.post("/book");
		
	}

}

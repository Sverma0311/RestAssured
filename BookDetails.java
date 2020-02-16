package com.book;


import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BookDetails {
	@BeforeSuite
	public void baseURI(){
		RestAssured.baseURI="http://localhost:4567";
	}
	
	@Test
	public void post(){
		System.out.println("add book details");
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-type","Application/json");
		
		JsonObject book = new JsonObject();
		book.addProperty("title", "Computer Aided Design");
		book.addProperty("author", "S. K. Srivastava");
		book.addProperty("price", 945.67);
		book.addProperty("category", "Engineering");
		
		 httpRequest.body(book.toString());
		 
		Response res = httpRequest.post("/book");
		System.out.println(book.toString());
		String expTitle = book.get("title").getAsString();
		
		System.out.println(res.getStatusCode());
		res.prettyPrint();
		int a =res.jsonPath().getInt("id");
		
        
		System.out.println("check book details");
		
		RequestSpecification getRequest = RestAssured.given();
		 Response resp = getRequest.get("/book?id="+a);
		 resp.prettyPrint();
		 String actTitle= resp.jsonPath().getString("title");
		 System.out.println(expTitle+" "+actTitle);
		 Assert.assertEquals(resp.getStatusCode(), res.getStatusCode());
		 Assert.assertEquals(expTitle, actTitle);
		 
	}
	
	
	
	@Test(enabled = false)
	public void get(){
		System.out.println("get book details");
		RequestSpecification httpRequest = RestAssured.given();
		
		Response res= httpRequest.get("/book");
		res.prettyPrint();
	}
	
	@Test(enabled = false)
	public void put(){
		System.out.println("update book details");
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-type","Application/json");
		
		JsonObject book = new JsonObject();
		book.addProperty("title", "Head First Java");
		book.addProperty("author", "Kathy Sierra");
		book.addProperty("price", 999.67);
		book.addProperty("category", "Engineering");
		
		Response res = httpRequest.put("/book?id=6");
		System.out.println(res.getStatusCode());
	}
	
	
		
		
		
		
		
	}



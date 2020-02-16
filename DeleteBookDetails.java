package com.book;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteBookDetails {
	@Test
	public void delete(){
		System.out.println("delete the book");
		
		String id ="/book?id=7";
		
		RequestSpecification getRequest = RestAssured.given();
		Response getResp = getRequest.get(id);
		String name = getResp.jsonPath().getString("title");
		System.out.println(name);
		if(name.isEmpty()){
			Assert.fail("Details are not found");
			return;
		}
		
		RequestSpecification httpRequest = RestAssured.given();
		Response delResp = httpRequest.delete(id);
		System.out.println(delResp.getStatusCode());
		Assert.assertEquals(200, delResp.getStatusCode());
		
		RequestSpecification getDelReq = RestAssured.given();
		Response getDelResp = getDelReq.get(id);
		System.out.println(getDelResp.asString());
		Assert.assertEquals(getDelResp.asString(), "null");

}
}

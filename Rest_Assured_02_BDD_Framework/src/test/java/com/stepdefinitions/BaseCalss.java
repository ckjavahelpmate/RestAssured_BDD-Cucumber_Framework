package com.stepdefinitions;

import com.utils.GenericUtils;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class BaseCalss 
{
	BaseUtils baseUtils ;
	static String url ;

	public BaseCalss(BaseUtils baseUtils) 
	{
		this.baseUtils = baseUtils;
	}

	@BeforeAll
	public static void beforeAllScenario() 
	{
		String envValue = GenericUtils.getPropertyValue("src/test/resources/global.properties", "ENV");
		url = GenericUtils.getPropertyValue("src/test/resources/"+envValue+".properties", "URL") ;
	}
	
	@Before
	public void beforeScenario() 
	{
//		Getting url from properties file
		RestAssured.baseURI = "https://api.github.com/";
		
//		Specifing the ResponseSpecification Header
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		responseSpecBuilder.expectHeader("Server", "GitHub.com");
		responseSpecBuilder.expectHeader("Content-type", "application/json; charset=utf-8");
		
		RestAssured.responseSpecification = responseSpecBuilder.build();
		
//		Initializing the RequestSpecification
		baseUtils.requestSpecification = RestAssured.given();

	}
	
	@BeforeStep
	public void beforeStep() 
	{
//		System.out.println("**********".repeat(10));
	}
	
	@AfterStep
	public void afterStep() 
	{
//		System.out.println("**********".repeat(10));
	}

	@After
	public void afterScenario() 
	{
		System.out.println("=============".repeat(10));
	}
	@AfterAll
	public static void afterAllScenario() 
	{
//		System.out.println("@@@@@@@@@".repeat(10));
	}

}

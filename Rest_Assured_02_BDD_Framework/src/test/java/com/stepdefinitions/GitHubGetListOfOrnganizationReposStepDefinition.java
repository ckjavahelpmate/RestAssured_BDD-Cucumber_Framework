package com.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.pojo.GitHubCreateGitRepoRequestPojo;
import com.utils.PojoHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

public class GitHubGetListOfOrnganizationReposStepDefinition 
{
BaseUtils baseUtils ;
	
	public GitHubGetListOfOrnganizationReposStepDefinition(BaseUtils baseUtils) 
	{
		this.baseUtils = baseUtils;
	}

	@Given("path param {string} with value {string}")
	public void pathParamWithValue(String pathParam, String pathValue) 
	{
		baseUtils.requestSpecification.pathParam(pathParam, pathValue);
	}

	@Given("query param {string} with value {string}")
	public void pathParamWithIntValue(String queryParam, String queryParamValue ) 
	{
		baseUtils.requestSpecification.queryParam(queryParam, queryParamValue) ;
	}

	@Given("header param {string} with value {string}")
	public void headerParamWithIntValue(String headerParam, String headerParamValue ) 
	{
		baseUtils.requestSpecification.header(headerParam, headerParamValue) ;
	}
	
	@Given("body param from file {string}")
	public void bodyParamFromFile(String fileName) 
	{
		String filePath = "src/test/resources/json-input/"+fileName ;
		try 
		{
			FileInputStream fin = new FileInputStream(filePath) ;
			baseUtils.requestSpecification.body(fin) ;
			baseUtils.requestSpecification.contentType(ContentType.JSON);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	@Given("body param input keys {string} and values {string}")
	public void bodyParamFromKeysAndValues(String keys, String values) 
	{
		GitHubCreateGitRepoRequestPojo pojo = PojoHelper.getGitHubCreateGitRepoPojo(keys, values);
		baseUtils.requestSpecification.body(pojo);
		baseUtils.requestSpecification.contentType(ContentType.JSON);
	}

	@When("I do GET request with URL {string}")
	public void iDoGetRequestWithUrl(String url) 
	{
		baseUtils.response =  baseUtils.requestSpecification.when().log().all().get(url);
	}

	@Then("I validate the status code is {int}")
	public void iValidateTheStatusCodeIs(Integer statuCode) 
	{
		baseUtils.response.then().statusCode(statuCode);
	}
	
	@Then("I validate the {string} is {string}")
	public void iValidateTheStatusCodeIs(String key, String value) 
	{
//		Inline body validation
		baseUtils.response.then().body(key, Matchers.equalTo(value));
		
//		Extract JsonPath Validation
		String actualValue = baseUtils.response.then().extract().jsonPath().getString(key) ;
		MatcherAssert.assertThat(actualValue, Matchers.equalTo(value));
	}

}



package com.stepdefinitions;

import com.pojo.GitHubCreateGitRepoResponsePojo;
import com.utils.PojoHelper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GitHubCreateRepoStepDefinition 
{
	BaseUtils baseUtils ;
	
	public GitHubCreateRepoStepDefinition(BaseUtils baseUtils) 
	{
		this.baseUtils = baseUtils;
	}

	@When("I do POST request with URL {string}")
	public void iDoPOSTRequestWithURL(String url) 
	{
		baseUtils.response =  baseUtils.requestSpecification.when().log().all().post(url);
	}
	
	@Then("I validate create repo response keys {string} and values {string}")
	public void iValidateCreateRepoResponse(String keys, String values) 
	{
		GitHubCreateGitRepoResponsePojo responsePojo = baseUtils.response.then().extract().as(GitHubCreateGitRepoResponsePojo.class);
		
		PojoHelper.iValidateCreateRepoResponse(responsePojo, keys, values);
		
	}

}



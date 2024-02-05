package com.utils;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.pojo.GitHubCreateGitRepoRequestPojo;
import com.pojo.GitHubCreateGitRepoResponsePojo;

public class PojoHelper 
{
	public static GitHubCreateGitRepoRequestPojo getGitHubCreateGitRepoPojo(String keys, String values) 
	{
		GitHubCreateGitRepoRequestPojo pojo = new GitHubCreateGitRepoRequestPojo();

		String[] inputKeys = keys.split(",");
		String[] inputValues = values.split(",");

		for (int i = 0; i < inputKeys.length; i++) 
		{
			if( inputKeys[i].equals("name"))
			{
				pojo.setName(inputValues[i]);
			}
			else if( inputKeys[i].equals("description"))
			{
				pojo.setDescription(inputValues[i]);
			}
			else if( inputKeys[i].equals("private"))
			{
				pojo.setPrivate(Boolean.valueOf(inputValues[i]));
			}
		}
		return pojo ;
	}
	public static void iValidateCreateRepoResponse(GitHubCreateGitRepoResponsePojo responsePojo ,String keys, String values) 
	{
		String[] inputKeys = keys.split(",");
		String[] inputValues = values.split(",");
		
		for (int i = 0; i < inputKeys.length; i++) 
		{
			if( inputKeys[i].equals("name"))
			{
				String actualName = responsePojo.getName();
				MatcherAssert.assertThat(actualName, Matchers.equalTo(inputValues[i]));
			}
			else if( inputKeys[i].equals("private"))
			{
				boolean isPrivate = responsePojo.isPrivate();
				MatcherAssert.assertThat(isPrivate, Matchers.equalTo(Boolean.valueOf(inputValues[i])));
			}
		}
	}
}

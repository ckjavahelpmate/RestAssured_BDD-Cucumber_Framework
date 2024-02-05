package com.pojo;

public class GitHubCreateGitRepoRequestPojo 
{
	private String name ;
	private String description ;
	private  boolean Private ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPrivate() {
		return Private;
	}
	public void setPrivate(boolean private1) {
		Private = private1;
	}
	
	
}

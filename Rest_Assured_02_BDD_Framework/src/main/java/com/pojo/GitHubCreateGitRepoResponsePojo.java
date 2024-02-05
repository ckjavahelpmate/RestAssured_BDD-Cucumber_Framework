package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubCreateGitRepoResponsePojo 
{
	private String name;
	private boolean isPrivate;
	private Owner Owner;
	private Organization organization ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isPrivate() {
		return isPrivate;
	}
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	public Owner getOwner() {
		return Owner;
	}
	public void setOwner(Owner owner) {
		Owner = owner;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
}

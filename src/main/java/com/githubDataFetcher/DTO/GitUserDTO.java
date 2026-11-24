package com.githubDataFetcher.DTO;

import org.springframework.stereotype.Component;
//Hello

@Component
public class GitUserDTO {
	private String id;
	private String fullName;
	private int noOfRepos;
	private String accountCreatedOn;
	private String lastUpdatedOn;
	private String company;
	private String TwitterUsername;
	private int publicGists;
	private int followers;
	private int following;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTwitterUsername() {
		return TwitterUsername;
	}

	public void setTwitterUsername(String twitterUsername) {
		TwitterUsername = twitterUsername;
	}

	public int getPublicGists() {
		return publicGists;
	}

	public void setPublicGists(int publicGists) {
		this.publicGists = publicGists;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getNoOfRepos() {
		return noOfRepos;
	}

	public void setNoOfRepos(int noOfRepos) {
		this.noOfRepos = noOfRepos;
	}

	public String getAccountCreatedOn() {
		return accountCreatedOn;
	}

	public void setAccountCreatedOn(String accountCreatedOn) {
		this.accountCreatedOn = accountCreatedOn;
	}

	public String getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(String lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

}

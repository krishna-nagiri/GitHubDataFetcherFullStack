package com.githubDataFetcher.service;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.githubDataFetcher.DTO.GitUserDTO;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class ResponseReader 
{
	
	GitUserDTO gitUserDto = new GitUserDTO();
	
	public GitUserDTO readUserData(String response) {
		if(response != "" || response != null) {
    		try {
    			ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(response);
                
                String id = root.get("id") != null ? root.get("id").asString() : "not found";
            	String username = root.get("name") != null ? root.get("name").asString() : "not found";
            	String company = root.get("company") != null ? root.get("company").asString() : "not found";
            	String TwitterUsername = root.get("twitter_username") != null ? root.get("twitter_username").asString() : "not found";
            	int publicRepos = root.get("public_repos") != null ? root.get("public_repos").asInt() : 0;
            	int publicGists = root.get("public_gists") != null ? root.get("public_gists").asInt() : 0;
            	int followers = root.get("followers") != null ? root.get("followers").asInt() : 0;
            	int following = root.get("following") != null ? root.get("following").asInt() : 0;
            	String accountCreatedOn = root.get("created_at") != null ? root.get("created_at").asString() : "not Available";
            	String lastUpdatedOn = root.get("updated_at") != null ? root.get("updated_at").asString() : "not Available";
            	
            	if(!accountCreatedOn.equals("not Available") && !lastUpdatedOn.equals("not Available")) {
            		ZonedDateTime accountCreatedOndateTime = ZonedDateTime.parse(accountCreatedOn);
            		DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            		String finalDate = accountCreatedOndateTime.format(formatter);
            		gitUserDto.setAccountCreatedOn(finalDate);
            		
            		ZonedDateTime lastUpdatedOn_dateTime = ZonedDateTime.parse(lastUpdatedOn);
            		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            		String finalLastUpdatedDate = lastUpdatedOn_dateTime.format(formatter2);
            		gitUserDto.setLastUpdatedOn(finalLastUpdatedDate);

            	}else {
            		gitUserDto.setAccountCreatedOn(null);
            		gitUserDto.setLastUpdatedOn(null);
            	}
            	
            	gitUserDto.setId(id);
            	gitUserDto.setFullName(username);
            	gitUserDto.setNoOfRepos(publicRepos);         	
            	gitUserDto.setCompany(company);
            	gitUserDto.setFollowers(followers);
            	gitUserDto.setFollowing(following);
            	gitUserDto.setPublicGists(publicGists);
            	gitUserDto.setTwitterUsername(TwitterUsername);
            	
            	return gitUserDto;
            	            	
            
    		}catch (NullPointerException npe) {
                System.out.println("NullPointerException caught! A field you tried to grab might not exist.");
                npe.printStackTrace();
            } catch(Exception e){
                System.out.println("Exception : " + e.getMessage());
            }
    	}
		return gitUserDto;
	}
	
}

package com.githubDataFetcher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController 
{

	@GetMapping("home")
	public String homeControllerTest() {
		return "Hello Krishna!.";
	}
	
	@GetMapping("/sayHi")
	public String sayHi() {
		return "Hi User!..";
	}
}

package com.githubDataFetcher.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.githubDataFetcher.DTO.GitUserDTO;
import com.githubDataFetcher.service.ResponseReader;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/GithubApi")
public class RequestRouter {

    HttpClient client;
    ResponseReader responseReader;

    public RequestRouter() {
        this.client = HttpClient.newHttpClient();
        this.responseReader = new ResponseReader();
    }

    @GetMapping("/getUsersData/{username}")
    public ResponseEntity<GitUserDTO> getUsersData(
            @PathVariable String username) {

        String url = "https://api.github.com/users/";
        String uri = url + username;

        String response = "";

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();

            HttpResponse<String> apiResponse = client.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code : " + apiResponse.statusCode());
            response = apiResponse.body() != null ? apiResponse.body(): "null";
            GitUserDTO opData = responseReader.readUserData(response);
            return ResponseEntity.ok(opData);
        } catch (Exception e) {
            System.out.println( "Error fetching user details : " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
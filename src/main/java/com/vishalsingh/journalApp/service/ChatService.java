package com.vishalsingh.journalApp.service;

import com.vishalsingh.journalApp.Api.responce.ChatResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ChatService {
    @Autowired
    private RestTemplate restTemplate;
    private static final String freshAPI ="https://en.wikipedia.org/w/api.php?action=query&prop=extracts&format=json&exintro=&titles={xx}";

    public ChatResponce chatInfo(String topic){
        String API = freshAPI.replace("{xx}",topic);
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "JournalApp/1.0 (https://github.com/vishalsingh; vishal@example.com)");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ChatResponce> response = restTemplate.exchange(
                API,
                HttpMethod.GET,
                entity,
                ChatResponce.class
        );

        return response.getBody();
    }
    }


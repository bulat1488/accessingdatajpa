package com.example.accessingdatajpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class WebService {

    private final RestTemplate restTemplate;
    private final URI uri = URI.create("https://webhook.site/37e52c52-9542-4d40-b683-d61fa2a974c2");

    @Autowired
    public WebService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Async
    public void send(Object request){
        restTemplate.postForEntity(uri, request, String.class);
    }
}
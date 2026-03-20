package com.example.loganalyzer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogService {

    public String processLog(String log) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8000/analyze?log=" + log;
        return restTemplate.postForObject(url, null, String.class);
    }
}

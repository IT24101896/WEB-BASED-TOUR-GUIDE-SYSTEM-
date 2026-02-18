package com.tourist.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;

@Service
public class MLIntegrationService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String ML_SERVICE_URL = "http://localhost:5000";

    public List<Long> searchSpots(String query) {
        try {
            Map<String, String> request = Collections.singletonMap("query", query);
            ResponseEntity<List> response = restTemplate.postForEntity(ML_SERVICE_URL + "/search", request, List.class);
            return (List<Long>) response.getBody();
        } catch (Exception e) {
            System.err.println("ML Service (Search) unavailable: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Map<String, Double> analyzeInterests(List<String> texts) {
        try {
            Map<String, List<String>> request = Collections.singletonMap("texts", texts);
            ResponseEntity<Map> response = restTemplate.postForEntity(ML_SERVICE_URL + "/analyze_text", request,
                    Map.class);
            return (Map<String, Double>) response.getBody();
        } catch (Exception e) {
            System.err.println("ML Service (Analyze) unavailable: " + e.getMessage());
            return Collections.emptyMap();
        }
    }
}

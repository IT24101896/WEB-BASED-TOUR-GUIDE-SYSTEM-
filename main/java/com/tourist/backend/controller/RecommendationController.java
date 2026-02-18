package com.tourist.backend.controller;

import com.tourist.backend.entity.Spot;
import com.tourist.backend.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin(origins = "http://localhost:5173")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public List<Spot> getRecommendations(@PathVariable Long userId,
            @RequestParam(required = false, defaultValue = "") String query) {
        return recommendationService.getRecommendations(userId, query);
    }
}

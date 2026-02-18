package com.tourist.backend.service;

import com.tourist.backend.entity.Spot;
import com.tourist.backend.entity.UserPreferences;
import com.tourist.backend.repository.SpotRepository;
import com.tourist.backend.repository.UserPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private SpotRepository spotRepository;

    @Autowired
    private UserPreferencesRepository userPreferencesRepository;

    @Autowired
    private MLIntegrationService mlIntegrationService;

    public List<Spot> getRecommendations(Long userId, String query) {
        // 1. Get User Preferences
        UserPreferences prefs = userPreferencesRepository.findByUserId(userId)
                .orElse(new UserPreferences()); // Default neutral prefs if not found

        // 2. Get Semantic Search Results from ML Service
        List<Long> similarSpotIds = mlIntegrationService.searchSpots(query);

        // If query is empty or no results, we might want to fallback to all spots or
        // browsing
        List<Spot> candidateSpots;
        if (similarSpotIds.isEmpty()) {
            candidateSpots = spotRepository.findAll();
        } else {
            candidateSpots = spotRepository.findAllById(similarSpotIds);
        }

        // 3. Rank Candidates
        // Formula: Score = 0.6 * SemanticScore + 0.4 * UserPrefScore
        // Note: For this prototype, we assume SemanticScore is 1.0 if returned by ML
        // search,
        // or we need to change MLIntegrationService to return scores.
        // For simplicity, let's assume ML returns sorted list and we assign linear
        // decay score or just use 1.0 for matches.

        return candidateSpots.stream()
                .sorted((s1, s2) -> Double.compare(calculateScore(s2, prefs), calculateScore(s1, prefs)))
                .collect(Collectors.toList());
    }

    private double calculateScore(Spot spot, UserPreferences prefs) {
        double semanticScore = 0.5; // Placeholder avg score
        // In real app, we'd get this from the ML service response for this specific
        // spot

        double userScore = getCategoryScore(spot.getCategory(), prefs);

        return (0.6 * semanticScore) + (0.4 * userScore);
    }

    private double getCategoryScore(String category, UserPreferences prefs) {
        if (category == null)
            return 0.0;
        switch (category.toLowerCase()) {
            case "beach":
                return prefs.getBeachScore();
            case "mountain":
                return prefs.getMountainScore();
            case "history":
                return prefs.getHistoryScore();
            case "nature":
                return prefs.getNatureScore();
            case "urban":
                return prefs.getUrbanScore();
            case "adventure":
                return prefs.getAdventureScore();
            default:
                return 0.0;
        }
    }
}

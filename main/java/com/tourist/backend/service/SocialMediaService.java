package com.tourist.backend.service;

import com.tourist.backend.entity.User;
import com.tourist.backend.entity.UserPreferences;
import com.tourist.backend.repository.UserPreferencesRepository;
import com.tourist.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SocialMediaService {

    @Autowired
    private MLIntegrationService mlIntegrationService;

    @Autowired
    private UserPreferencesRepository userPreferencesRepository;

    @Autowired
    private UserRepository userRepository;

    public void connectAndAnalyze(Long userId, List<String> mockPosts) {
        // 1. Analyze posts via ML Service
        Map<String, Double> interestScores = mlIntegrationService.analyzeInterests(mockPosts);

        // 2. Update User Preferences
        UserPreferences prefs = userPreferencesRepository.findByUserId(userId)
                .orElse(new UserPreferences());

        User user = userRepository.findById(userId).orElseThrow();
        prefs.setUser(user);

        // Update scores (simple replacement or weighted average in future)
        if (interestScores.containsKey("Beach"))
            prefs.setBeachScore(interestScores.get("Beach"));
        if (interestScores.containsKey("Mountain"))
            prefs.setMountainScore(interestScores.get("Mountain"));
        if (interestScores.containsKey("History"))
            prefs.setHistoryScore(interestScores.get("History"));
        if (interestScores.containsKey("Nature"))
            prefs.setNatureScore(interestScores.get("Nature"));
        if (interestScores.containsKey("Urban"))
            prefs.setUrbanScore(interestScores.get("Urban"));
        if (interestScores.containsKey("Adventure"))
            prefs.setAdventureScore(interestScores.get("Adventure"));

        userPreferencesRepository.save(prefs);

        // 3. Update User Status
        user.setSocialMediaConnected(true);
        userRepository.save(user);
    }
}

package com.tourist.backend.controller;

import com.tourist.backend.entity.User;
import com.tourist.backend.entity.UserPreferences;
import com.tourist.backend.repository.UserRepository;
import com.tourist.backend.repository.UserPreferencesRepository;
import com.tourist.backend.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173") // Allow frontend
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPreferencesRepository userPreferencesRepository;

    @Autowired
    private SocialMediaService socialMediaService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/{userId}/social-connect") // Renamed to be clearer but endpoint path is what matters
    public String connectSocials(@PathVariable Long userId, @RequestBody List<String> mockPosts) {
        socialMediaService.connectAndAnalyze(userId, mockPosts);
        return "Social media connected and analyzed!";
    }

    @PostMapping("/{userId}/preferences")
    public UserPreferences updatePreferences(@PathVariable Long userId, @RequestBody UserPreferences prefs) {
        User user = userRepository.findById(userId).orElseThrow();
        UserPreferences existingPrefs = userPreferencesRepository.findByUserId(userId).orElse(new UserPreferences());
        existingPrefs.setUser(user);

        if (prefs.getBeachScore() != null)
            existingPrefs.setBeachScore(prefs.getBeachScore());
        if (prefs.getMountainScore() != null)
            existingPrefs.setMountainScore(prefs.getMountainScore());
        if (prefs.getHistoryScore() != null)
            existingPrefs.setHistoryScore(prefs.getHistoryScore());
        if (prefs.getNatureScore() != null)
            existingPrefs.setNatureScore(prefs.getNatureScore());
        if (prefs.getUrbanScore() != null)
            existingPrefs.setUrbanScore(prefs.getUrbanScore());
        if (prefs.getAdventureScore() != null)
            existingPrefs.setAdventureScore(prefs.getAdventureScore());

        return userPreferencesRepository.save(existingPrefs);
    }
}

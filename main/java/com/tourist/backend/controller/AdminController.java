package com.tourist.backend.controller;

import com.tourist.backend.entity.Spot;
import com.tourist.backend.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/spots")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    @Autowired
    private SpotRepository spotRepository;

    // GET all spots
    @GetMapping
    public List<Spot> getAllSpots() {
        return spotRepository.findAll();
    }

    // CREATE a new spot
    @PostMapping
    public Spot createSpot(@RequestBody Spot spot) {
        return spotRepository.save(spot);
    }

    // UPDATE an existing spot
    @PutMapping("/{id}")
    public ResponseEntity<Spot> updateSpot(@PathVariable Long id, @RequestBody Spot spotDetails) {
        return spotRepository.findById(id).map(spot -> {
            spot.setName(spotDetails.getName());
            spot.setCategory(spotDetails.getCategory());
            spot.setDescription(spotDetails.getDescription());
            spot.setImageUrl(spotDetails.getImageUrl());
            return ResponseEntity.ok(spotRepository.save(spot));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE a spot
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpot(@PathVariable Long id) {
        if (spotRepository.existsById(id)) {
            spotRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

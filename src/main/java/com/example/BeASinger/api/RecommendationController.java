package com.example.BeASinger.api;

import com.example.BeASinger.domain.Recommandation;
import com.example.BeASinger.domain.Singer;
import com.example.BeASinger.exception.BadRequestException;
import com.example.BeASinger.repository.RecommendationRepository;
import com.example.BeASinger.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {
    @Autowired
    private RecommendationRepository recommendationRepository;

    @GetMapping
    public List<Recommandation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Recommandation getRecommendationById(@PathVariable Integer id) {
        return recommendationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Recommendation not found"));
    }

    @PostMapping
    public Recommandation createRecommendation(@RequestBody Recommandation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    @PutMapping("/{id}")
    public Recommandation updateRecommendation(@PathVariable Integer id, @RequestBody Recommandation recommendationDetails) {
        Recommandation recommendation = recommendationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Recommendation not found"));
        recommendation.setSong(recommendationDetails.getSong());
        recommendation.setSong(recommendationDetails.getSong());
        recommendation.setRecommendationDate(recommendationDetails.getRecommendationDate());
        return recommendationRepository.save(recommendation);
    }

    @DeleteMapping("/{id}")
    public void deleteRecommendation(@PathVariable Integer id) {
        Recommandation recommendation = recommendationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Recommendation not found"));
        recommendationRepository.delete(recommendation);
    }
}

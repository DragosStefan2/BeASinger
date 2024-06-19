package com.example.BeASinger.repository;

import com.example.BeASinger.domain.Recommandation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommandation, Integer> {
    List<Recommandation> findBySingerId(Integer singerId);
}

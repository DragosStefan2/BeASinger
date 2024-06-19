package com.example.BeASinger.domain;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="recommendation",schema="public")
public class Recommandation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Singer singer;

    @ManyToOne
    private Song song;

    @Column(name = "recommendation_date")
    private LocalDate recommendationDate;

    // Constructors, getters, setters
    public Recommandation() {
    }

    public Recommandation(Singer singer, Song song, LocalDate recommendationDate) {
        this.singer = singer;
        this.song = song;
        this.recommendationDate = recommendationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public LocalDate getRecommendationDate() {
        return recommendationDate;
    }

    public void setRecommendationDate(LocalDate recommendationDate) {
        this.recommendationDate = recommendationDate;
    }
}

package com.example.BeASinger.dto;

import java.time.LocalDate;

public class RecommandationDto {
    private int id;
    private int singerId;
    private int songId;
    private LocalDate recommendationDate;

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public LocalDate getRecommendationDate() {
        return recommendationDate;
    }

    public void setRecommendationDate(LocalDate recommendationDate) {
        this.recommendationDate = recommendationDate;
    }
}

package com.example.BeASinger.dto;

public class SongDto {
    private int id;
    private String title;
    private String artist;
    private String tone;
    private String semitone;

    // getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public String getSemitone() {
        return semitone;
    }

    public void setSemitone(String semitone) {
        this.semitone = semitone;
    }
}

package com.example.BeASinger.domain;

import jakarta.persistence.*;

@Entity
@Table(name="song",schema="public")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String artist;
    private String tone;
    private String semitone;
    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;

    // Constructors, getters, setters
    // Omitted for brevity

    public Song() {
    }

    public Song(String title, String artist, String tone, Singer singer) {
        this.title = title;
        this.artist = artist;
        this.tone = tone;
        this.singer = singer;
    }

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

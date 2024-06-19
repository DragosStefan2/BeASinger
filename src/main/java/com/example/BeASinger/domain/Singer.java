package com.example.BeASinger.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="singer",schema="public")
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String genre;

    private int age;

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL)
    private Set<Song> songs;

    // Constructors, getters, setters
    // Omitted for brevity

    public Singer() {
    }

    public Singer(String name, String genre, int age) {
        this.name = name;
        this.genre = genre;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}

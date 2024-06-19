package com.example.BeASinger.repository;

import com.example.BeASinger.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findByToneAndSemitone(String tone, String semitone);

    @Query("SELECT s FROM Song s WHERE (:title is null or s.title = :title) " +
            "AND (:artist is null or s.artist = :artist) ")
    List<Song> findSongsByCriteria(@Param("title") String title,
                                   @Param("artist") String artist);
}

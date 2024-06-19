package com.example.BeASinger.api;

import com.example.BeASinger.domain.Song;
import com.example.BeASinger.exception.BadRequestException;
import com.example.BeASinger.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    @Autowired
    private SongRepository songRepository;

    @GetMapping
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Integer id) {
        return songRepository.findById(id).orElseThrow(() -> new BadRequestException("Song not found"));
    }

    @GetMapping("/search")
    public List<Song> getSongsByToneAndSemitone(@RequestParam("tone") String tone, @RequestParam("semitone") String semitone) {
        return songRepository.findByToneAndSemitone(tone, semitone);
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songRepository.save(song);
    }

    @PutMapping("/{id}")
    public Song updateSong(@PathVariable Integer id, @RequestBody Song songDetails) {
        Song song = songRepository.findById(id).orElseThrow(() -> new BadRequestException("Song not found"));
        song.setTitle(songDetails.getTitle());
        song.setArtist(songDetails.getArtist());
        song.setTone(songDetails.getTone());
        song.setSemitone(songDetails.getSemitone());
        return songRepository.save(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Integer id) {
        Song song = songRepository.findById(id).orElseThrow(() -> new BadRequestException("Song not found"));
        songRepository.delete(song);
    }
}

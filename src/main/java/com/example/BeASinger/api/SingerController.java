package com.example.BeASinger.api;

import com.example.BeASinger.domain.Singer;
import com.example.BeASinger.exception.BadRequestException;
import com.example.BeASinger.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/singers")
public class SingerController {
    @Autowired
    private SingerRepository singerRepository;

    @GetMapping
    public List<Singer> getAllSingers() {
        return singerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Singer getSingerById(@PathVariable Integer id) {
        return singerRepository.findById(id).orElseThrow(() -> new BadRequestException("Singer not found"));
    }

    @PostMapping
    public Singer createSinger(@RequestBody Singer singer) {
        return singerRepository.save(singer);
    }

    @PutMapping("/{id}")
    public Singer updateSinger(@PathVariable Integer id, @RequestBody Singer singerDetails) {
        Singer singer = singerRepository.findById(id).orElseThrow(() -> new BadRequestException("Singer not found"));
        singer.setName(singerDetails.getName());
        singer.setAge(singerDetails.getAge());
        singer.setGenre(singerDetails.getGenre());
        return singerRepository.save(singer);
    }

    @DeleteMapping("/{id}")
    public void deleteSinger(@PathVariable Integer id) {
        Singer singer = singerRepository.findById(id).orElseThrow(() -> new BadRequestException("Singer not found"));
        singerRepository.delete(singer);
    }
}

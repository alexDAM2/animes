package com.example.animes.controller;

import com.example.animes.domain.model.Animes;
import com.example.animes.domain.model.projection.ProjectionAnime;
import com.example.animes.repository.AnimesRepository;

import com.example.animes.domain.dto.ListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.UUID;

@RestController
@RequestMapping("/animes")
public class AnimesController {

    @Autowired
    private AnimesRepository animeRepository;

    @GetMapping("/")
    public ResponseEntity<?> findAllAnimes(Authentication authentication){
        return ResponseEntity.ok().body(ListResult.list(animeRepository.findBy())); // return ResponseEntity.ok().body();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAnimeById(@PathVariable UUID id) {
        ProjectionAnime anime = animeRepository.findByAnimeid(id);
        return ResponseEntity.ok().body(anime);
    }

    @PostMapping("/")
    public ResponseEntity<?> createAnime(@RequestBody Animes anime, Authentication authentication){
        return ResponseEntity.ok().body(animeRepository.save(anime));
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteAnime(@PathVariable UUID id, Authentication authentication){
        animeRepository.delete(animeRepository.getById(id));
    }
}

package com.example.animes.controller;

import com.example.animes.domain.dto.ResponseList;
import com.example.animes.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autors")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/")
    public ResponseEntity<?> findAllAutors(Authentication authentication){
        return ResponseEntity.ok().body(new ResponseList(autorRepository.findBy()));
    }
}

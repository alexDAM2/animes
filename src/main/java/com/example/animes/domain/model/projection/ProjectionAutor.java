package com.example.animes.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

public interface ProjectionAutor {
    UUID getAutorId();
    String getName();

}

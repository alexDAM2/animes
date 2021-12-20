package com.example.animes.repository;

import com.example.animes.domain.model.Animes;
import com.example.animes.domain.model.projection.ProjectionAnime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AnimesRepository extends JpaRepository<Animes, UUID> {

    List<ProjectionAnime> findBy();

    ProjectionAnime findByAnimeid(UUID id);

}

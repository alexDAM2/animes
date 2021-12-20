package com.example.animes.repository;

import com.example.animes.domain.dto.FileResult;
import com.example.animes.domain.model.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FilesRepository extends JpaRepository<Files, UUID> {

    @Query("select fileid from File")
    List<String> getFileIds();

    List<FileResult> findBy();
}

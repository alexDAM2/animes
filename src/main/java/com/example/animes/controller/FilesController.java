package com.example.animes.controller;

import com.example.animes.domain.dto.ErrorMessage;
import com.example.animes.domain.dto.FileResult;
import com.example.animes.domain.model.Files;
import com.example.animes.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@RestController
@RequestMapping("/files")
public class FilesController {

    @Autowired
    private FilesRepository filesRepository;

    @PostMapping
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile uploadedFile) {
        try {
            Files file = new Files();
            file.contenttype = uploadedFile.getContentType();
            file.data = uploadedFile.getBytes();

            Files savedFile = filesRepository.save(file);

            FileResult fileResult = new FileResult(savedFile.fileid, savedFile.contenttype);

            return ResponseEntity.ok().body(fileResult);
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFile(@PathVariable UUID id, Authentication authentication) {
        Files file = filesRepository.findById(id).orElse(null);

        if (file == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ErrorMessage.message("File not found"));

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(file.contenttype))
                .contentLength(file.data.length)
                .body(file.data);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllFiles(Authentication authentication){
        return ResponseEntity.ok().body(filesRepository.findBy());
    }

    @DeleteMapping("/delete")
    public void deleteAllFiles(Authentication authentication){
        filesRepository.deleteAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteFile(@PathVariable UUID id, Authentication authentication){
        filesRepository.delete(filesRepository.getById(id));
    }

}

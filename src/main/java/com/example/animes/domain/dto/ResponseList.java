package com.example.animes.domain.dto;

import com.example.animes.domain.model.projection.ProjectionAnime;

import java.util.List;

public class ResponseList {

    public List<?> result;

    public ResponseList(List<?> result) {
        this.result = result;
    }

    public static ResponseList list(List<?> result){
        return new ResponseList(result);
    }
}

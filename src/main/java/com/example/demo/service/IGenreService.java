package com.example.demo.service;

import com.example.demo.models.Genre;

import java.util.ArrayList;
import java.util.List;

public interface IGenreService {

    default List<Genre> getAllGenres(){
        return new ArrayList<>();
    }


    default Genre saveGenreRecord(Genre genre) throws Exception {
        return null;
    }


    default void deleteGenreById(Long id) {
    }
}

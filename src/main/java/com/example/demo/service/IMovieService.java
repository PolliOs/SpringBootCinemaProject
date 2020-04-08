package com.example.demo.service;


import com.example.demo.models.Movie;
import com.example.demo.service.exception.ContainerException;

import java.util.ArrayList;
import java.util.List;

public interface IMovieService {

    default List<Movie> getAllMovies(){
        return new ArrayList<>();
    }
    default Movie saveMovieRecord(Movie movie) throws ContainerException {
        return null;
    }
    default Movie findMovieById(Long iid) {
        return null;
    }
    default void deleteMovieById(Long id) {
    }
}

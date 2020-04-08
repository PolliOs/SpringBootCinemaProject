package com.example.demo.service;

import com.example.demo.models.Movie;
import com.example.demo.repository.MoviesRepository;
import com.example.demo.service.exception.ContainerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service("movieService")
public class MovieService implements IMovieService {

    @Autowired
    MoviesRepository moviesRepository;

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        Iterable<Movie> itr = moviesRepository.findAll();
        for (Movie movie : itr) {
            movies.add(movie);
        }
        return movies;
    }

    @Override
    public Movie saveMovieRecord(Movie movieToAdd) throws ContainerException {
        ContainerException ex = new ContainerException();

        boolean flag = false;
        for(Movie movie:moviesRepository.findAll()){
            if(movieToAdd.getMovieTitle().equals(movie.getMovieTitle()) && !movieToAdd.equals(movie)){
                ex.add(new Exception("duplicate"));
                flag = true;
            }
        }
        int year = Year.now().getValue();
        if(movieToAdd.getYear() > year || movieToAdd.getYear() < 1900){
            ex.add(new Exception("year"));
            flag = true;
        }
        if(movieToAdd.getDuration() > 1000 || movieToAdd.getDuration()<1){
            ex.add(new Exception("duration"));
            flag=true;
        }
        if(flag){
            throw ex;
        }
        return moviesRepository.save(movieToAdd);
    }
    //
    @Override
    public Movie findMovieById(Long id) {
        return moviesRepository.findMovieById(id);
    }

    @Override
    public void deleteMovieById(Long id) {
        Movie movieToDelete = moviesRepository.findMovieById(id);
        moviesRepository.delete(movieToDelete);
    }
}


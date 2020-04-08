package com.example.demo.service;

import com.example.demo.models.Genre;
import com.example.demo.repository.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("genreService")
public class GenreService implements IGenreService {

    @Autowired
    GenresRepository genresRepository;

    @Override
    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        Iterable<Genre> itr = genresRepository.findAll();
        for (Genre genre : itr) {
            genres.add(genre);
        }
        return genres;
    }

    @Override
    public Genre saveGenreRecord(Genre genreToAdd) throws Exception {
        for(Genre genre:genresRepository.findAll()){
            if(genreToAdd.getGenreTitle().equals(genre.getGenreTitle()) && !genreToAdd.equals(genre)){
                throw new Exception() ;
            }
        }
        return genresRepository.save(genreToAdd);
    }

    @Override
    public void deleteGenreById(Long id) {
        Genre genreToDelete = genresRepository.findGenreById(id);
        genresRepository.delete(genreToDelete);
    }
}

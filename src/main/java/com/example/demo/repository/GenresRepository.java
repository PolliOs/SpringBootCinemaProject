package com.example.demo.repository;

import com.example.demo.models.Book;
import com.example.demo.models.Genre;
import com.example.demo.models.Hall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface GenresRepository extends CrudRepository<Genre, Long> {


    @Query(value = "select o from Genre o where id = :id")
    Genre findGenreById(@Param("id") Long id);

//    @Query(value = "select o from Book o where book_title like %:bookTitle%")
//    public List<Book> findByBookTitle(@Param("bookTitle") String bookTitle);

}

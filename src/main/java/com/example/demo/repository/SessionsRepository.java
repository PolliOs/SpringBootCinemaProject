package com.example.demo.repository;

import com.example.demo.models.Session;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SessionsRepository extends CrudRepository<Session, Long> {


    @Query(value = "select o from Session o where id = :id")
    Session findSessionById(@Param("id") Long id);


    @Modifying
    @Query("DELETE from Session s WHERE s.movie.id = ?1")
    void deleteByMovieId(Long movieId);

    @Modifying
    @Query("DELETE from Session s WHERE s.hall.id = ?1")
    void deleteByHallId(Long hallId);

}
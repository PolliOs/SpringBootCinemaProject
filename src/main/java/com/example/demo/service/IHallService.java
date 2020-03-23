package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.models.Hall;

import java.util.ArrayList;
import java.util.List;

public interface IHallService {

    public default List<Hall> getAllHalls(){
        return new ArrayList<>();
    }


    public default Hall saveHallRecord(Hall hall) throws Exception {
        return null;
    }
    public default Hall findHallById(Long id) {
        return null;
    }


    public default void deleteHallById(Long id) {
    }
}

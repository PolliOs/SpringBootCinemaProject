package com.example.demo.service;

import com.example.demo.models.Hall;
import com.example.demo.service.exception.ContainerException;

import java.util.ArrayList;
import java.util.List;

public interface IHallService {

    default List<Hall> getAllHalls(){
        return new ArrayList<>();
    }


    default Hall saveHallRecord(Hall hall) throws ContainerException {
        return null;
    }
    default Hall findHallById(Long id) {
        return null;
    }


    default void deleteHallById(Long id) {
    }
}

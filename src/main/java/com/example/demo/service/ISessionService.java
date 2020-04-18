package com.example.demo.service;


import com.example.demo.models.Session;
import com.example.demo.service.exception.ContainerException;

import java.util.ArrayList;
import java.util.List;

public interface ISessionService {

    default List<Session> getAllSessions(){
        return new ArrayList<>();
    }
    default Session saveSessionRecord(Session session) throws ContainerException {
        return null;
    }
    default Session findSessionById(Long id) {
        return null;
    }
    default void deleteSessionById(Long id) {
    }
}

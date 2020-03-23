package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.models.Hall;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.HallsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("hallService")
public class HallService implements IHallService {

    @Autowired
    HallsRepository hallsRepository;

    @Override
    public List<Hall> getAllHalls() {
        List<Hall> halls = new ArrayList<>();
        Iterable<Hall> itr = hallsRepository.findAll();
        for (Hall hall : itr) {
            halls.add(hall);
        }
        return halls;
    }

    @Override
    public Hall saveHallRecord(Hall hallToAdd) throws Exception {
        for(Hall hall:hallsRepository.findAll()){
            if(hallToAdd.getHallTitle().equals(hall.getHallTitle()) && !hallToAdd.equals(hall)){
                System.out.println("DUPLICATE!");
                throw new Exception() ;
            }
        }
        return hallsRepository.save(hallToAdd);
    }
//
    @Override
    public Hall findHallById(Long id) {
        return hallsRepository.findHallById(id);
    }

    @Override
    public void deleteHallById(Long id) {
        Hall hallToDelete = hallsRepository.findHallById(id);
        hallsRepository.delete(hallToDelete);
    }
}
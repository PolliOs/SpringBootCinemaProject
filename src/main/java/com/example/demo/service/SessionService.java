package com.example.demo.service;

import com.example.demo.models.Session;
import com.example.demo.repository.SessionsRepository;
import com.example.demo.service.exception.ContainerException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("sessionService")
public class SessionService implements ISessionService {

    final
    SessionsRepository sessionsRepository;

    public SessionService(SessionsRepository sessionsRepository) {
        this.sessionsRepository = sessionsRepository;
    }

    @Override
    public List<Session> getAllSessions() {
        List<Session> sessions = new ArrayList<>();
        Iterable<Session> itr = sessionsRepository.findAll();
        for (Session session : itr) {
            sessions.add(session);
        }
        return sessions;
    }

    @Override
    public Session saveSessionRecord(Session sessionToAdd) throws ContainerException {
        ContainerException ex = new ContainerException();

        boolean flag = false;
        int startTime = findIntTime(sessionToAdd.getTime().toString());
        for(Session session:sessionsRepository.findAll()){
            if(!sessionToAdd.equals(session) && findCollisions(session, sessionToAdd, startTime)){
                ex.add(new Exception("collision"));
                flag = true;
                break;
            }
        }
        if(sessionToAdd.getPrice() < 0){
            ex.add(new Exception("price"));
            flag = true;
        }
        if(flag){
            throw ex;
        }
        return sessionsRepository.save(sessionToAdd);
    }

    private boolean findCollisions(Session session, Session sessionToAdd,int startTime) {
        if(!session.getDay().equals(sessionToAdd.getDay())) return false;
        if(!session.getHall().equals(sessionToAdd.getHall())) return false;
        int startTimeOfExistedSession = findIntTime(session.getTime().toString());
        int endTimeOfExistedSession = startTimeOfExistedSession + session.getMovie().getDuration();
        int duration = sessionToAdd.getMovie().getDuration();
        return !(endTimeOfExistedSession <= startTime || startTime + duration <= startTimeOfExistedSession);
    }

    private int findIntTime(String time) {
        Pattern pattern = Pattern.compile("[0-9]{2}:[0-9]{2}");
        Matcher matcher = pattern.matcher(time);
        String startTime = "";
        if(matcher.find()) {
            startTime = matcher.group();
        }else{
            System.out.println("!!!!");
        }
        String[] splitTime = startTime.split(":");
        return Integer.parseInt(splitTime[0])*60 + Integer.parseInt(splitTime[1]);
    }

    @Override
    public Session findSessionById(Long id) {
        return sessionsRepository.findSessionById(id);
    }

    @Override
    public void deleteSessionById(Long id) {
        Session sessionToDelete = sessionsRepository.findSessionById(id);
        sessionsRepository.delete(sessionToDelete);
    }
}


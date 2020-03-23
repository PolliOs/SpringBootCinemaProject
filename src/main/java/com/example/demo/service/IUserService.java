package com.example.demo.service;

import org.springframework.security.core.userdetails.User;

public interface IUserService {
    public default User findUserByName(String username){
        return null;
    }
}

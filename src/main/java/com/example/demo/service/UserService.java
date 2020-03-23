package com.example.demo.service;


import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public User findUserByName(String username) {
        com.example.demo.models.User userFromBd = userRepository.findByUserName(username);
        if(userFromBd == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        User user = new User(username, userFromBd.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return findUserByName(username);
    }
}

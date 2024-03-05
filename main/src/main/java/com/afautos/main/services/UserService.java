package com.afautos.main.services;

import org.springframework.stereotype.Service;

import com.afautos.main.models.User;

@Service
public interface UserService {
    User getByIdUser(String id);

    User addUser(User user);
}
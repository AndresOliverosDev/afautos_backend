package com.afautos.main.services.user;

import org.springframework.stereotype.Service;

import com.afautos.main.models.user.User;

@Service
public interface UserService {
    User getByIdUser(String id);

    User addUser(User user);
}
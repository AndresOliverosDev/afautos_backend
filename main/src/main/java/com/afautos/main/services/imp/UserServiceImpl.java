package com.afautos.main.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afautos.main.models.User;
import com.afautos.main.repositories.UserRepository;
import com.afautos.main.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("null")
    @Override
    public User getByIdUser(String id) {
        return userRepository.findById(id).orElse(null);
    };
}

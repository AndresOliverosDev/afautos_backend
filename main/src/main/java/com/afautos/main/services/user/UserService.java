package com.afautos.main.services.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afautos.main.dto.user.UserDTO;
import com.afautos.main.models.user.User;

@Service
public interface UserService {

    List<UserDTO> getAllUser();

    User getByIdUser(String id);

    User addUser(User user);
}
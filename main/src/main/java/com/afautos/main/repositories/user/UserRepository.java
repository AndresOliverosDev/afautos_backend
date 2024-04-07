package com.afautos.main.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.afautos.main.dto.user.UserDTO;
import com.afautos.main.models.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    @Query("SELECT new com.afautos.main.dto.user.UserDTO(u.id, u.email, u.phone, u.names, u.lastname, u.birthday, u.docType.name, a.ref) FROM User u JOIN u.address a")
    List<UserDTO> getAllUser();
}

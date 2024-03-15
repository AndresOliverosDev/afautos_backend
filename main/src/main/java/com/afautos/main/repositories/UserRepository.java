package com.afautos.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    @Query("SELECT u,d.name FROM User u JOIN u.docType d from u.id = ?1?")
    User findByIdWithRol();
}

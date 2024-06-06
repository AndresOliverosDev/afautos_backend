package com.afautos.businessmanagement.persistence.repository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.presentation.dto.user.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.user.UserDTO" +
            "(u.id, u.username, u.email, u.phone, u.name, u.birthday, u.docType.name, r.name) "
            +
            "FROM UserEntity u " +
            "JOIN u.roles r")
    public List<UserDTO> getAllUser();

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    Optional<UserEntity> findByUsername(@Param("username") String username);
}

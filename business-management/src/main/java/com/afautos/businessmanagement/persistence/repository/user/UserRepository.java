package com.afautos.businessmanagement.persistence.repository.user;

import java.time.LocalDate;
import java.util.*;

import com.afautos.businessmanagement.presentation.dto.user.response.CustomerResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.presentation.dto.user.response.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.user.response.CustomerResponseDTO(" +
            "u.id, u.name, u.phone, u.email, u.docType.name) " +
            "FROM UserEntity u " +
            "JOIN u.roles r " +
            "WHERE r.name = 'CLIENTE'")
    List<CustomerResponseDTO> getAllCustomers();

    @Query("SELECT u.id, u.username, u.email, u.phone, u.name, u.birthday, u.docType.name, r.name " +
            "FROM UserEntity u " +
            "JOIN u.roles r")
    List<Object[]> getAllUserTuples();

    default List<UserDTO> getAllUser() {
        List<Object[]> tuples = getAllUserTuples();
        Map<String, UserDTO> userMap = new HashMap<>();

        for (Object[] tuple : tuples) {
            String id = (String) tuple[0];
            String username = (String) tuple[1];
            String email = (String) tuple[2];
            String phone = (String) tuple[3];
            String name = (String) tuple[4];
            LocalDate birthday = (LocalDate) tuple[5];
            String docType = (String) tuple[6];
            String rol = (String) tuple[7];

            UserDTO userDTO = userMap.get(id);
            if (userDTO == null) {
                userDTO = new UserDTO(id, username, email, phone, name, birthday, docType, new HashSet<>());
                userMap.put(id, userDTO);
            }
            userDTO.roles().add(rol);
        }

        return new ArrayList<>(userMap.values());
    }

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    Optional<UserEntity> findByUsername(@Param("username") String username);
}

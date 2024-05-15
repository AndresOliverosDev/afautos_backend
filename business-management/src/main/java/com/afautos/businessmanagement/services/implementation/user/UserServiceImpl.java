package com.afautos.businessmanagement.services.implementation.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.persistence.entity.user.DocTypeEntity;
import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.persistence.entity.user.rol.RolEntity;
import com.afautos.businessmanagement.persistence.repository.user.DocTypeRepository;
import com.afautos.businessmanagement.persistence.repository.user.RolRepository;
import com.afautos.businessmanagement.persistence.repository.user.UserRepository;
import com.afautos.businessmanagement.presentation.dto.user.UserAddDTO;
import com.afautos.businessmanagement.presentation.dto.user.UserDTO;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocTypeRepository docTypeRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public ResponseEntity<String> addUser(UserAddDTO userAdd) {

        try {
            
            UserEntity userIdDuplicated = userRepository.findById(userAdd.id()).orElse(null);

            if (userIdDuplicated != null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El Usuario ya existe");
            }

            // Document Type
            DocTypeEntity docTypeCurrent = docTypeRepository.findById(userAdd.docType()).orElse(null);
            if (docTypeCurrent == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El tipo de documento no existe");
            }

            // Roles
            Set<RolEntity> rolesCurrent = new HashSet<>();

            for (Byte rolId : userAdd.roles()) {
                RolEntity rolEntity = rolRepository.findById(rolId).orElse(null);
                if (rolEntity != null) {
                    rolesCurrent.add(rolEntity);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El rol " + rolId + " No existe");
                }
            }
            String passwordEncoder = new BCryptPasswordEncoder().encode(userAdd.password());

            UserEntity userEntity = new UserEntity();
            userEntity.setId(userAdd.id());
            userEntity.setUsername(userAdd.username());
            userEntity.setPassword(passwordEncoder);
            userEntity.setEmail(userAdd.email());
            userEntity.setPhone(userAdd.phone());
            userEntity.setName(userAdd.name());
            userEntity.setSurname(userAdd.surname());
            userEntity.setBirthday(userAdd.birthday());
            userEntity.setIsEnable(true);
            userEntity.setAccountNoExpired(true);
            userEntity.setAccountNoLocked(true);
            userEntity.setCredentialNoExpired(true);
            userEntity.setDocType(docTypeCurrent);
            userEntity.setRoles(rolesCurrent);

            userRepository.save(userEntity);

            return ResponseEntity.ok("El usuario con el ID " + userAdd.id() + " Se creo correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el usuario");
        }
    }

}

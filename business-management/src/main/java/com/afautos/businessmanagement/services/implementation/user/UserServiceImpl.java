package com.afautos.businessmanagement.services.implementation.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.afautos.businessmanagement.error.NotFoundException;
import com.afautos.businessmanagement.presentation.dto.user.response.CustomerResponseDTO;
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
import com.afautos.businessmanagement.presentation.dto.user.request.UserRequestDTO;
import com.afautos.businessmanagement.presentation.dto.user.response.UserDTO;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    // Dependency injection

    private final UserRepository userRepository;
    private final DocTypeRepository docTypeRepository;
    private final RolRepository rolRepository;

    public UserServiceImpl(UserRepository userRepository, DocTypeRepository docTypeRepository, RolRepository rolRepository) {
        this.userRepository = userRepository;
        this.docTypeRepository = docTypeRepository;
        this.rolRepository = rolRepository;
    }

    // Read

    @Override
    public UserEntity getUserEntityById(String id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return userRepository.getAllCustomers();
    }

    @Override
    public ResponseEntity<String> addUser(UserRequestDTO userAdd) {
        try {

            // Check if the user already exists
            UserEntity userIdDuplicated = userRepository.findById(userAdd.id()).orElse(null);
            if (userIdDuplicated != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya existe");
            }

            // Search Document Type
            DocTypeEntity docTypeCurrent = docTypeRepository.findById(userAdd.docType()).orElse(null);
                if (docTypeCurrent == null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("El tipo de documento con id " + userAdd.docType() + " no existe");
                }

            // Search Roles
            Set<RolEntity> rolesCurrent = new HashSet<>();
            for (Byte rolId : userAdd.roles()) {
                RolEntity rolEntity = rolRepository.findById(rolId).orElse(null);
                if (rolEntity != null) {
                    rolesCurrent.add(rolEntity);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El rol con id " + rolId + " no existe");
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
            userEntity.setBirthday(userAdd.birthday());
            userEntity.setStatus("ACTIVE");
            userEntity.setIsEnable(true);
            userEntity.setAccountNoExpired(true);
            userEntity.setAccountNoLocked(true);
            userEntity.setCredentialNoExpired(true);
            userEntity.setDocType(docTypeCurrent);
            userEntity.setRoles(rolesCurrent);

            userRepository.save(userEntity);

            return ResponseEntity.ok("Usuario creado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el usuario");
        }
    }

}

package com.afautos.businessmanagement.services.implementation.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import com.afautos.businessmanagement.services.interfaces.address.IAddressService;
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
import com.afautos.businessmanagement.presentation.dto.user.request.UserAddDTO;
import com.afautos.businessmanagement.presentation.dto.user.response.UserDTO;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    // Dependency injection

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocTypeRepository docTypeRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private IAddressService addressService;

    // Methods

    @Override
    public UserEntity getUserById(String id) throws LocalNotFoundException {
        return userRepository.findById(id).orElseThrow(() ->
            new LocalNotFoundException("El usuario con el id " + id + " no existe")
        );
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public UserEntity addUser(UserAddDTO userAdd, List<AddressEntity> addressEntity) {

        try {

            // Check if the user already exists
            UserEntity userIdDuplicated = userRepository.findById(userAdd.id()).orElse(null);
            if (userIdDuplicated != null) {
                throw new RuntimeException("El usuario ya existe");
            }

            // Search Document Type
            DocTypeEntity docTypeCurrent = docTypeRepository.findById(userAdd.docType()).orElseThrow(() ->
                    new LocalNotFoundException("El tipo de documento con id " + userAdd.docType() + " no existe"));

            // Search Roles
            Set<RolEntity> rolesCurrent = new HashSet<>();
            for (Byte rolId : userAdd.roles()) {
                RolEntity rolEntity = rolRepository.findById(rolId).orElse(null);
                if (rolEntity != null) {
                    rolesCurrent.add(rolEntity);
                } else {
                    throw new LocalNotFoundException("El rol con id " + rolId + " no existe");
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
            userEntity.setAddress(addressEntity);
            userEntity.setIsEnable(true);
            userEntity.setAccountNoExpired(true);
            userEntity.setAccountNoLocked(true);
            userEntity.setCredentialNoExpired(true);
            userEntity.setDocType(docTypeCurrent);
            userEntity.setRoles(rolesCurrent);

            userRepository.save(userEntity);

            return userEntity;
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el usuario");
        }
    }

}

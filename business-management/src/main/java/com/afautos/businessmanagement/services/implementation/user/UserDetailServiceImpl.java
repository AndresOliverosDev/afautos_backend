package com.afautos.businessmanagement.services.implementation.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.persistence.repository.user.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("El usuario" + username + "no existe"));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userEntity.getRoles()
            .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));

        userEntity.getRoles().stream()
            .flatMap(role -> role.getPermissions().stream())
            .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(
            userEntity.getUsername(),
            userEntity.getPassword(),
            userEntity.getIsEnable(),
            userEntity.getAccountNoExpired(),
            userEntity.getCredentialNoExpired(),
            userEntity.getAccountNoLocked(),
            authorityList
        );
    }
    
}

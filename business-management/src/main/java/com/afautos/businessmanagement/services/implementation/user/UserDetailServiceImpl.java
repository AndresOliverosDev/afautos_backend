package com.afautos.businessmanagement.services.implementation.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.persistence.repository.user.UserRepository;
import com.afautos.businessmanagement.presentation.dto.authentication.request.AuthLoginRequest;
import com.afautos.businessmanagement.presentation.dto.authentication.response.AuthResponse;
import com.afautos.businessmanagement.util.JwtUtils;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

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
    
    public AuthResponse loginUser(AuthLoginRequest authLoginRequest){
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate(username, password);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String accessToken = jwtUtils.createToken(authentication);

        AuthResponse authResponse = new AuthResponse(username, "User logged successful", accessToken, true);
        return authResponse;
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("invalid username or password.");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("invalid password.");
        }
        
        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }
}

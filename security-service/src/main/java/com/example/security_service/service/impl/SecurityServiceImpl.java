package com.example.security_service.service.impl;

import com.example.security_service.dto.AuthRequest;
import com.example.security_service.dto.UserDTO;
import com.example.security_service.exception.UserAlreadyExistsException;
import com.example.security_service.exception.UsernameNotFoundException;
import com.example.security_service.mapper.UserMapperImpl;
import com.example.security_service.repository.UserRepository;
import com.example.security_service.service.SecurityService;
import com.example.security_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapperImpl userMapperImpl;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public String register(UserDTO userDTO) {
        if(userRepository.findByUsername(userDTO.getUsername()) != null){
            throw new UserAlreadyExistsException();
        }
        String encodedPassword;
        encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        userRepository.save(userMapperImpl.toUserEntity(userDTO));

        return "User registered successfully!";
    }

    @Override
    public String login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if(authentication.isAuthenticated()){
            return jwtUtil.generateToken(authentication);
        }else{
            throw new UsernameNotFoundException();
        }
    }
}

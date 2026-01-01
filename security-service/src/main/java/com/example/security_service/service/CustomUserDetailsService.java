package com.example.security_service.service;

import com.example.security_service.dto.CustomUserDetails;
import com.example.security_service.entity.UserEntity;
import com.example.security_service.mapper.UserMapper;
import com.example.security_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity= userRepository.findByUsername(username);
        if(userEntity==null){
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(userMapper.toUserDto(userEntity));
    }
}

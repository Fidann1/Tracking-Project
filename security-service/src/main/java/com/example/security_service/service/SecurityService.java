package com.example.security_service.service;

import com.example.security_service.dto.AuthRequest;
import com.example.security_service.dto.UserDTO;

public interface SecurityService {

    public String register(UserDTO userDTO);
    public String login(AuthRequest authRequest);
}

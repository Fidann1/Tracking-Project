package com.example.security_service.controller;

import com.example.security_service.dto.AuthRequest;
import com.example.security_service.dto.UserDTO;
import com.example.security_service.service.SecurityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SecurityService securityService;

    @PostMapping("/register")
    public String register( @RequestBody @Valid UserDTO userDTO){
       return  securityService.register(userDTO);
    }

    @GetMapping("/login")
    public String login(@RequestBody @Valid AuthRequest authRequest){
        return  securityService.login(authRequest);
    }


}

package com.example.security_service.dto;

import com.example.security_service.enums.UserRoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank(message = "Username can not be blank")
    private String username;

    @NotBlank(message = "Password can not be blank")
    private String password;

    @NotBlank(message = "Email can not be blank")
    private String email;

    @NotBlank(message = "Phone can not be blank")
    private String phone;

    @NotNull(message = "Role can not be blank")
    private UserRoleEnum role;

}

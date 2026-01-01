package com.example.security_service.mapper;

import com.example.security_service.dto.UserDTO;
import com.example.security_service.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDto(UserEntity userEntity);
    UserEntity toUserEntity(UserDTO userDTO);
}

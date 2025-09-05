package com.anfega.api.mapper;

import com.anfega.api.dto.CreateUserDTO;
import com.anfega.api.dto.UserDTO;
import com.anfega.model.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
    UserDTO toResponse(User user);
    User toModel(CreateUserDTO createUserDTO);
}

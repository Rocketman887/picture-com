package ru.itis.springbootdemo.dtos.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.models.User;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "email", source = "user.email"),
            @Mapping(target = "name", source = "user.username"),
            @Mapping(target = "role", source = "user.role"),
            @Mapping(target = "state", source = "user.state"),
            @Mapping(target = "code", source = "user.currentConfirmationCode")
    })
    UserDTO userToDto(User user);

    @InheritInverseConfiguration
    User dtoToUser(UserDTO userDto);
}

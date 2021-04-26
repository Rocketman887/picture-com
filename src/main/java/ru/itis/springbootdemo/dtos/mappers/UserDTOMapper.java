package ru.itis.springbootdemo.dtos.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.models.User;

@Mapper(componentModel="spring")
public interface UserDTOMapper {
    UserDTOMapper MAPPER = Mappers.getMapper(UserDTOMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "email", source = "user.email"),
            @Mapping(target = "name", source = "user.name"),
            @Mapping(target = "role", source = "user.role"),
            @Mapping(target = "state", source = "user.state"),
            @Mapping(target = "code", source = "user.currentConfirmationCode"),
            @Mapping(target = "imagePath", source = "user.profileImagePath")
    })
    UserDTO userToDto(User user);

    @InheritInverseConfiguration
    User dtoToUser(UserDTO userDto);

    @Mappings({
            @Mapping(target = "email", source = "userDTO.email"),
            @Mapping(target = "name", source = "userDTO.name")
    })
    UserForm userDTOToForm(UserDTO userDTO);

    @InheritInverseConfiguration
    UserDTO formToUserDTO(UserForm form);


}

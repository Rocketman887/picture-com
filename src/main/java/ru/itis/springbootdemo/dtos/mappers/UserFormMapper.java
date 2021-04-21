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
public interface UserFormMapper {

    UserFormMapper MAPPER = Mappers.getMapper(UserFormMapper.class);

    @Mappings({
            @Mapping(target = "email", source = "form.email"),
            @Mapping(target = "name", source = "form.name")
    })
    User formToUser(UserForm form);

    @InheritInverseConfiguration
    UserForm userToForm(User user);

    @Mappings({
            @Mapping(target = "email", source = "form.email"),
            @Mapping(target = "name", source = "form.name")
    })
    UserDTO formToUserDTO(UserForm form);

    @InheritInverseConfiguration
    UserForm userDTOToForm(UserDTO userDTO);
}
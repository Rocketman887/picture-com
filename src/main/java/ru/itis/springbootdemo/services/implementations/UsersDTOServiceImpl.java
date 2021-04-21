package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.dtos.mappers.UserDTOMapper;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.services.interfacies.UsersDTOService;
import ru.itis.springbootdemo.services.interfacies.UsersService;

@Service
@RequiredArgsConstructor
public class UsersDTOServiceImpl implements UsersDTOService {

    private final UsersService usersService;

    @Override
    public UserDTO fromUserForm(UserForm userForm) {
        UserDTO userDTO = UserDTOMapper.MAPPER.formToUserDTO(userForm);
        userDTO.setId(usersService.getUserByEmail(userForm.getEmail()).getId());
        userDTO.setCode(usersService.getUserByEmail(userForm.getEmail()).getCurrentConfirmationCode());
        return userDTO;
    }

    @Override
    public UserDTO userToDto(User user) {
        return UserDTOMapper.MAPPER.userToDto(user);
    }
}

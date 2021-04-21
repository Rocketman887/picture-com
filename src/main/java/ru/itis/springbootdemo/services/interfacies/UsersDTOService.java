package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.dtos.dtos.UserDTO;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.models.User;

public interface UsersDTOService {
    UserDTO fromUserForm(UserForm userForm);
    UserDTO userToDto(User user);
}

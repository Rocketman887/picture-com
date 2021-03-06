package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.dtos.mappers.UserFormMapper;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.interfacies.SignUpService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    private UserFormMapper userFormMapper;


    @Override
    public boolean signUp(UserForm form) {
        if (usersRepository.existsByEmail(form.getEmail())) {
            return false;
        } else {

            User newUser = userFormMapper.FormToUser(form);

            newUser.setRole(User.Role.USER);
            newUser.setState(User.State.ACTIVE);
            newUser.setCurrentConfirmationCode(UUID.randomUUID().toString());

            usersRepository.save(newUser);
            return true;
        }
    }
}


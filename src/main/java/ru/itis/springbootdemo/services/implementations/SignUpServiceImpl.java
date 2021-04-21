package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dtos.forms.UserForm;
import ru.itis.springbootdemo.dtos.mappers.UserDTOMapper;
import ru.itis.springbootdemo.dtos.mappers.UserFormMapper;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.interfacies.MailMessageCreator;
import ru.itis.springbootdemo.services.interfacies.SenderService;
import ru.itis.springbootdemo.services.interfacies.SignUpService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UsersRepository usersRepository;
    private final SenderService senderService;
    private final MailMessageCreator mailMessageCreator;
    private final PasswordEncoder passwordEncoder;

    @Value("${server.basic.address}")
    private String link;

    @Value("${default.image.path}")
    private String defaultImagePath;

    @Override
    public boolean signUp(UserForm form) {
        if (usersRepository.existsByEmail(form.getEmail())&&
                usersRepository.existsByName(form.getName())) {
            return false;
        } else {

            User newUser = UserFormMapper.MAPPER.formToUser(form);

            newUser.setHashPassword(passwordEncoder.encode(form.getPassword()));
            newUser.setRole(User.Role.USER);
            newUser.setState(User.State.ACTIVE);
            newUser.setCurrentConfirmationCode(UUID.randomUUID().toString());

            newUser.setProfileImagePath(defaultImagePath);

            usersRepository.save(newUser);

            senderService.sendMail(newUser.getEmail(),
                    "Activation code",
                    mailMessageCreator.createMailMessage(
                            UserDTOMapper.MAPPER.userToDto(newUser),link ));
            return true;
        }
    }

}


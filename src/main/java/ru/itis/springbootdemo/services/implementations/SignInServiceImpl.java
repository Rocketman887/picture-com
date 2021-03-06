package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.interfacies.MailService;
import ru.itis.springbootdemo.services.interfacies.SignInService;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final MailService mailService;


}

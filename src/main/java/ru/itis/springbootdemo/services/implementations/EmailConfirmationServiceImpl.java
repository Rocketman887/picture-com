package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.interfacies.EmailConfirmationService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmailConfirmationServiceImpl implements EmailConfirmationService {

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public boolean confirmByCode(String code) {
        Optional<User> userCandidate = usersRepository.findByCurrentConfirmationCode(code);
        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            user.setMailProved(true);
            usersRepository.save(user);
        }
        return userCandidate.isPresent();
    }
}


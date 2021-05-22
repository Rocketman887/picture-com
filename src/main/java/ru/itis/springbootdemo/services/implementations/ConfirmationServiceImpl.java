package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.interfacies.ConfirmationService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfirmationServiceImpl implements ConfirmationService {

    private final UsersRepository usersRepository;

    @Override
    public boolean activateUser(String code) {
        Optional<User> userCandidate = usersRepository.findByCurrentConfirmationCode(code);
        if(!userCandidate.isPresent()){
            return false;
        }

        User newUser = userCandidate.get();
        newUser.setMailProved(true);
        usersRepository.save(newUser);
        return true;
    }

}

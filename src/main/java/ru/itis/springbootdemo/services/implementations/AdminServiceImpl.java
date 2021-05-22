package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.interfacies.AdminService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UsersRepository usersRepository;

    @Override
    public void banUserById(Long id) {
        User userForBan = usersRepository.findById(id).get();
        userForBan.setState(User.State.BANNED);
        usersRepository.save(userForBan);
    }

    @Override
    public void banAllUsers() {
        List<User> usersList = usersRepository.findAll();
        for (User user : usersList) {
            if (!user.isAdmin()) {
                user.setState(User.State.BANNED);
                usersRepository.save(user);
            }
        }
    }

    @Override
    public void unBanUserById(Long id) {
        User userForBan = usersRepository.findById(id).get();
        userForBan.setState(User.State.ACTIVE);
        usersRepository.save(userForBan);
    }

    @Override
    public void unBanAllUsers() {
        List<User> usersList = usersRepository.findAll();
        for (User user : usersList) {
            if (!user.isAdmin()) {
                user.setState(User.State.ACTIVE);
                usersRepository.save(user);
            }
        }
    }
}

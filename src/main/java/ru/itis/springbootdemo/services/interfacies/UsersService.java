package ru.itis.springbootdemo.services.interfacies;

import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.util.List;

public interface UsersService {
    User getUserByEmail(String email);
    User getUserById(Long id);
    boolean existByName(String name);
    boolean existByEmail(String email);
    List<User> getAllUsers();
    void saveUser(User user);
}

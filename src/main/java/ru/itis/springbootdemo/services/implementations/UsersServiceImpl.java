package ru.itis.springbootdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.interfacies.UsersService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email).get();
    }

    @Override
    public User getUserById(Long id){ return usersRepository.findById(id).get();}

    @Override
    public boolean existByName(String name) {
        return usersRepository.existsByName(name);
    }

    @Override
    public boolean existByEmail(String email) {
        return usersRepository.existsByEmail(email);
    }


    @Override
    public void saveUser(User user){
        usersRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }
}
